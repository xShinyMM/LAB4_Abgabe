package order.service;

import order.service.publisher.OrderPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderPublisher publisher;

    public OrderController(OrderPublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping("/send")
    public String sendOrder(@RequestBody String message) {
        publisher.sendOrder(message);
        return "Nachricht gesendet: " + message;
    }
}