package com.doth.product_comsumer_kafka.binding;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ProductOrdersBinding {

    final static String PRODUCT_ORDER_INPUT = "poin";
    final static String PRODUCT_ORDER_OUTPUT = "poout";

    final static String PRODUCT_ORDER_ANALYTICS_OUTPUT = "paout";
    final static String PRODUCT_ORDER_ANALYTICS_INPUT = "pain";

    final static String PRODUCT_ORDER_STREAM_INPUT = "posin";

    final static String PRODUCT_ORDER_CATEGORY_COUNT = "PO-category-count";

    @Input(PRODUCT_ORDER_INPUT)
    SubscribableChannel productsOrderIn();


    @Input(PRODUCT_ORDER_STREAM_INPUT)
    KStream<?, ?> productsOrderStreamIn();

    @Input(PRODUCT_ORDER_ANALYTICS_INPUT)
    KStream<?, ?> productsOrderAnalyticsIn();

    @Input(PRODUCT_ORDER_ANALYTICS_OUTPUT)
    KStream<?, ?> productsOrderAnalyticsOut();

}
