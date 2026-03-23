package com.example.tracing.service2.core;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OrderRequest {
    private final String orderNumber;
    private final Long userId;
}
