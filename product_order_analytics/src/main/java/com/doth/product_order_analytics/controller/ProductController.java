package com.doth.product_order_analytics.controller;

import com.doth.product_order_analytics.model.Product;
import com.doth.product_order_analytics.processor.binding.ProductOrdersBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

@RestController
@RequestMapping("/product")
@EnableBinding(ProductOrdersBinding.class)
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    BlockingQueue<Product> unbounded = new LinkedBlockingQueue<>();

    @PostMapping
    public ResponseEntity<Product> delegateToSupplier(@RequestBody Product product){
        unbounded.offer(product);
        logger.info("Person sent={}, {}, {}", product.getName(), product.getCategory(), product.getQuantity());
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Bean
    public Supplier<Product> processProduct() {
        return () -> unbounded.poll();
    }
}
