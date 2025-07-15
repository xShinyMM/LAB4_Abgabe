package com.payment.listener;

import com.payment.MessagingConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessage(String message) {
        System.out.println("Empfangen: " + message);
    }
}

