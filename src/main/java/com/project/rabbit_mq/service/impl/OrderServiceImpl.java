package com.project.rabbit_mq.service.impl;

import com.project.rabbit_mq.domain.usecase.IOrderUsecase;
import com.project.rabbit_mq.listener.dto.OrderCreatedEvent;
import com.project.rabbit_mq.service.IOrderService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderServiceImpl implements IOrderService {

    IOrderUsecase usecase;

    @Override
    public void create(OrderCreatedEvent event) {
        usecase.create(event);
    }

}
