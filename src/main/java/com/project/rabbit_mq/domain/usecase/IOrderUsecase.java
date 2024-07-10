package com.project.rabbit_mq.domain.usecase;

import com.project.rabbit_mq.listener.dto.OrderCreatedEvent;

public interface IOrderUsecase {

    void create(OrderCreatedEvent event);

}
