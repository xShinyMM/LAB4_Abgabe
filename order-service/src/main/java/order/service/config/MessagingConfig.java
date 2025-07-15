package order.service.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    public static final String EXCHANGE = "order_exchange";
    public static final String ROUTING_KEY = "order_key";

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

}
