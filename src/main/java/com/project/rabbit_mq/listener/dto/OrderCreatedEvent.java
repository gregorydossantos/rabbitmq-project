package com.project.rabbit_mq.listener.dto;

import java.util.List;

public record OrderCreatedEvent(
        Long orderId,
        Long customerId,
        List<ItemEvent> items
) {}
