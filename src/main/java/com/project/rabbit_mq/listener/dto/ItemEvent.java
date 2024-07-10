package com.project.rabbit_mq.listener.dto;

import java.math.BigDecimal;

public record ItemEvent(
        String product,
        Integer quantity,
        BigDecimal price
) {}
