package com.project.rabbit_mq.service;

import com.project.rabbit_mq.listener.dto.OrderCreatedEvent;

public interface IOrderService {

    void create(OrderCreatedEvent event);

}
