package com.payment.model;

import com.payment.MessagingConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabasePollingService {

    @Autowired
    private DatabaseEventRepository repository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedRate = 5000) // alle 5 Sekunden
    public void pollDatabase() {
        List<DatabaseEvent> newEvents = repository.findByProcessedFalse();
        for (DatabaseEvent e : newEvents) {
            rabbitTemplate.convertAndSend(
                    MessagingConfig.EXCHANGE,
                    MessagingConfig.ROUTING_KEY,
                    e.getMessage()
            );
            e.setProcessed(true);
            repository.save(e);
        }
    }
}
