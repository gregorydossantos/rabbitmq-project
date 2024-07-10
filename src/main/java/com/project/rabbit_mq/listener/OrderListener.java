package com.project.rabbit_mq.listener;

import com.project.rabbit_mq.listener.dto.OrderCreatedEvent;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static com.project.rabbit_mq.config.RabbitMqConfig.CREATE_QUEUE;

@Log
@Component
public class OrderListener {

    @RabbitListener(queues = CREATE_QUEUE)
    public void create(Message<OrderCreatedEvent> message) {
        log.info("Listing the queue CREATE!!!");
    }
}
