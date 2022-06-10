package com.doth.product_comsumer_kafka.controller;

import com.doth.product_comsumer_kafka.binding.ProductOrdersBinding;
import com.doth.product_comsumer_kafka.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

@RestController
@RequestMapping("/shop")
@EnableBinding(ProductOrdersBinding.class)
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);
    BlockingQueue<Product> unbounded = new LinkedBlockingQueue<>();
//
//    @GetMapping("analytics")
//    public ResponseEntity<Product> delegateToSupplier(){
//        Product product = new Product();
//        try {
//            product = unbounded.take();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(product, HttpStatus.OK);
//    }



}
