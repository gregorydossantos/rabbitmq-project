package com.project.rabbit_mq.domain.usecase.impl;

import com.project.rabbit_mq.domain.usecase.IOrderUsecase;
import com.project.rabbit_mq.infra.db.model.Item;
import com.project.rabbit_mq.infra.db.model.Order;
import com.project.rabbit_mq.infra.db.repository.IOrderRepository;
import com.project.rabbit_mq.listener.dto.OrderCreatedEvent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderUseCaseImpl implements IOrderUsecase {

    IOrderRepository orderRepository;

    @Override
    public void create(OrderCreatedEvent event) {
        var order = new Order();
        order.setOrderId(event.orderId());
        order.setCustomerId(event.customerId());
        order.setItems(getOrderItems(event));
        order.setTotal(getTotal(event));

        orderRepository.save(order);
    }

    private static List<Item> getOrderItems(OrderCreatedEvent event) {
        return event.items().stream()
                .map(itemEvent -> new Item(itemEvent.product(), itemEvent.quantity(), itemEvent.price()))
                .toList();
    }

    private BigDecimal getTotal(OrderCreatedEvent event) {
        return event.items().stream()
                .map(itemEvent -> itemEvent.price().multiply(BigDecimal.valueOf(itemEvent.quantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

}
