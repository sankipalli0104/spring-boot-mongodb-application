package spring.boot.mongo.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.boot.mongo.demo.document.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}

