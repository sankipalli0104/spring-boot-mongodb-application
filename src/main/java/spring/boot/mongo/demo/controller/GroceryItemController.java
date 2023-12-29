package spring.boot.mongo.demo.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.*;
import spring.boot.mongo.demo.document.GroceryItem;
import spring.boot.mongo.demo.repository.ItemRepository;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/v1/items")
public class GroceryItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<GroceryItem> getAllItems() {
        List<GroceryItem> all = itemRepository.findAll();
        return all;
    }

    @PostMapping
    public GroceryItem saveItems(@RequestBody GroceryItem groceryItem) {
        return itemRepository.save(groceryItem);
    }

    @GetMapping(value = "/getByCategory/{category}")
    public List<GroceryItem> getItemByCategory(@PathVariable String category) {
        List<GroceryItem> itemByCategory = itemRepository.findItemByCategoryIgnoreCase(category);
        itemByCategory.stream().forEach(item -> System.out.println(item));
        return itemByCategory;
    }

    @GetMapping(value = "/getByCategory/{category}/{quantity}")
    public List<GroceryItem> getItemByCategoryAndQuantity(@PathVariable String category, @PathVariable int quantity) {
        List<GroceryItem> itemByCategory = itemRepository.findItemByCategoryIgnoreCase(category);
        List<GroceryItem> updatedItems = itemByCategory.stream()
                .filter(item -> item.getQuantity() >= quantity)
                .collect(Collectors.toList());

//        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://asiva494:test1234@cluster0.qmppuoe.mongodb.net")) {
//            MongoDatabase database = mongoClient.getDatabase("test-database");
//        MongoCollection<Document> collection = database.getCollection("grocery_items");
//
//        // Specify the filter to get veggies with more than 5 quantity
//        List<Document> updatedItems = collection.find(
//                Filters.and(
//                        Filters.eq("category", "Veggies"),
//                        Filters.gt("quantity", 5)
//                )
//        ).into(new ArrayList<>());
        return updatedItems;
    }


}
