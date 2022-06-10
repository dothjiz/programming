package com.doth.product_order_analytics.config;

import com.doth.product_order_analytics.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;
import java.util.function.Supplier;

@Configuration
public class ProductAnalyticsConfig {

    private final Logger logger = LoggerFactory.getLogger(ProductAnalyticsConfig.class);

    @Bean
    public Supplier<Product> processProduct() {
        logger.info("logged");
    }

}
