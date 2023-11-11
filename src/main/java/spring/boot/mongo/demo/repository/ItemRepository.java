package spring.boot.mongo.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import spring.boot.mongo.demo.document.GroceryItem;

import java.util.List;

public interface ItemRepository extends MongoRepository<GroceryItem, String> {

    //@Query("{'category': ?0}.collation({locale:'en', strength:2})")
    List<GroceryItem> findItemByCategoryIgnoreCase(String category);


}
