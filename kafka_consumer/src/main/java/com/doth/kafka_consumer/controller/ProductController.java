package com.doth.kafka_consumer.controller;

import com.doth.kafka_consumer.binding.ProductOrdersBinding;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.state.KeyValueIterator;

import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/shop")
@EnableBinding(ProductOrdersBinding.class)
public class ProductController {
    private final InteractiveQueryService interactiveQueryService;
    private final ConsumerComponent consumerComponent;

    @Autowired
    public ProductController(InteractiveQueryService interactiveQueryService, ConsumerComponent consumerComponent) {
        this.interactiveQueryService = interactiveQueryService;
        this.consumerComponent = consumerComponent;
    }

    @GetMapping("/analytics")
    public ResponseEntity<Map<String, String>> analytics(){
        Map<String, String> result = new LinkedHashMap<>();
        float total = 0L;

        ReadOnlyKeyValueStore<String, Long> keyValueStore =
                interactiveQueryService.getQueryableStore(
                        ProductOrdersBinding.PRODUCT_ORDER_CATEGORY_COUNT,
                        QueryableStoreTypes.keyValueStore()
                );

        KeyValueIterator<String, Long> iterator = keyValueStore.all();
        while (iterator.hasNext()){
            KeyValue<String, Long> kv = iterator.next();
            total+=kv.value;
        }
        result.put("Total Orders ", total + "");

        KeyValueIterator<String, Long> iterator2 = keyValueStore.all();
        while (iterator2.hasNext()){
            KeyValue<String, Long> kv = iterator2.next();
            result.put(kv.key, Math.round((kv.value.floatValue()/total)*100)+"%");
        }
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }
}
