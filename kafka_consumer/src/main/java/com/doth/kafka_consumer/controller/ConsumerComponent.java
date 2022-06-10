package com.doth.kafka_consumer.controller;

import com.doth.kafka_consumer.binding.ProductOrdersBinding;
import com.doth.kafka_consumer.model.Product;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Printed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import static com.doth.kafka_consumer.binding.ProductOrdersBinding.PRODUCT_ORDER_INPUT;


@Component
public class ConsumerComponent {

    private final MessageChannel productOrdersIn;
    private Logger logger = LoggerFactory.getLogger(ConsumerComponent.class);

    @Autowired
    public ConsumerComponent(ProductOrdersBinding productOrdersBinding){
        this.productOrdersIn = productOrdersBinding.productsOrderIn();
    }

    @StreamListener(PRODUCT_ORDER_INPUT)
    private void sink(Product product){
        logger.info("New product... {}, {}, {}", product.getName(), product.getCategory(), product.getQuantity());
    }

    @StreamListener(ProductOrdersBinding.PRODUCT_ORDER_STREAM_INPUT)
    @SendTo(ProductOrdersBinding.PRODUCT_ORDER_ANALYTICS_OUTPUT)
    public KStream<String, Product> process(KStream<String, Product> input){
        return input.filter((key, value) -> value.getQuantity() > 0);
    }

    @StreamListener(ProductOrdersBinding.PRODUCT_ORDER_ANALYTICS_INPUT)
    public void processAnalytics(KStream<String, Product> input){
        input.map((key, value) -> new KeyValue<>(value.getCategory(), 0L))
                .groupByKey(Grouped.with(Serdes.String(), Serdes.Long()))
                .count(Materialized.as(ProductOrdersBinding.PRODUCT_ORDER_CATEGORY_COUNT))
                .toStream()
                .print(Printed.toSysOut());
    }

}
