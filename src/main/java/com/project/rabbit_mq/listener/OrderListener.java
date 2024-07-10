package com.project.rabbit_mq.listener;

import com.project.rabbit_mq.listener.dto.OrderCreatedEvent;
import com.project.rabbit_mq.service.IOrderService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static com.project.rabbit_mq.config.RabbitMqConfig.CREATE_QUEUE;

@Log
@Component
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderListener {

    IOrderService service;

    @RabbitListener(queues = CREATE_QUEUE)
    public void create(Message<OrderCreatedEvent> message) {
        log.info("Rabbit-MQ QUEUE ::: CREATE ");
        service.create(message.getPayload());
    }

}
