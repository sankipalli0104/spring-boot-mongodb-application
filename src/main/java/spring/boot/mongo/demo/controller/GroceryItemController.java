package spring.boot.mongo.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.boot.mongo.demo.document.GroceryItem;
import spring.boot.mongo.demo.repository.ItemRepository;

import java.util.List;

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


}
