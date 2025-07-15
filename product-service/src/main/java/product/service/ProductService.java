package product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public String getProduct(Long id) {
        Optional<Products> product = productRepository.findById(id);
        return product.map(p -> "Product: " + p.getName()).orElse("Product not found");
    }
}