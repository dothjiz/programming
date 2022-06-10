package com.doth.product_comsumer_kafka;

import com.doth.product_comsumer_kafka.controller.ProductController;
import com.doth.product_comsumer_kafka.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class ProductConsumerKafkaApplication {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    public static void main(String[] args) {
        SpringApplication.run(ProductConsumerKafkaApplication.class, args);
    }

    @Bean
    public Consumer<Product> processProduct() {
        return product -> logger.info("product: Consumer {}, {}, {}", product.getName(), product.getCategory(), product.getCategory());
    }

}
