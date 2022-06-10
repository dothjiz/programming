package com.doth.product_comsumer_kafka.controller;

import com.doth.product_comsumer_kafka.binding.ProductOrdersBinding;
import com.doth.product_comsumer_kafka.model.Product;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import static com.doth.product_comsumer_kafka.binding.ProductOrdersBinding.PRODUCT_ORDER_INPUT;
import static com.doth.product_comsumer_kafka.binding.ProductOrdersBinding.PRODUCT_ORDER_STREAM_INPUT;

@Component
public class ConsumerComponent {
    private Logger logger = LoggerFactory.getLogger(ConsumerComponent.class);


    @StreamListener(PRODUCT_ORDER_INPUT)
    private void sink(Product product){
        logger.info("New product... {}, {}, {}", product.getName(), product.getCategory(), product.getQuantity());
    }

//    @StreamListener(PRODUCT_ORDER_STREAM_INPUT)
//    @SendTo(ProductOrdersBinding.PRODUCT_ORDER_ANALYTICS_OUTPUT)
//    public KStream<String, Product> process(KStream<String, Product> input){
//        return input.filter((key, value) -> value.getQuantity() > 0);
//    }

}
