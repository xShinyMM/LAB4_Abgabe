package order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public String getOrder(Long id) {
        Optional<Orders> order = orderRepository.findById(id);
        if (order.isPresent()) {
            // Fetch user details from UserService
            String user = restTemplate.getForObject("http://localhost:8081/users/" + order.get().getUserId(), String.class);

            // Fetch product details from ProductService
            String product = restTemplate.getForObject("http://localhost:8083/products/" + order.get().getProductId(), String.class);

            return "Order: " + order.get().getId() +
                    ", " + user +
                    ", " + product +
                    ", Quanitity: " + order.get().getQuantity();
        }
        return "Order not found";
    }
}