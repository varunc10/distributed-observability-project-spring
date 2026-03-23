package com.example.tracing.service1.client;

import com.example.tracing.service1.core.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service3", url = "http://localhost:8003")
public interface Service3Client {

    @PostMapping(path = "/api/v1/tracing/service3")
    void createOrder(@RequestBody OrderRequest orderRequest);
}
