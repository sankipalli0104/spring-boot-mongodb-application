package spring.boot.mongo.demo.controller;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import spring.boot.mongo.demo.document.Product;
import spring.boot.mongo.demo.repository.ProductRepository;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        logger.info("Request received");
        long startTime = System.currentTimeMillis();
         List<Product> productList =  productRepository.findAll();
        long endTime = System.currentTimeMillis();
        logger.info("Request Successful. Response Time {} ms",startTime-endTime);
        return productList;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}

