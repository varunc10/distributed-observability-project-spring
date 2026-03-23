package com.example.tracing.service2.client;


import com.example.tracing.service2.core.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service4", url = "http://localhost:8004")
public interface Service4Client {

    @PostMapping(path = "/api/v1/tracing/service4")
    void createOrder(@RequestBody OrderRequest orderRequest);
}
