package spring.boot.mongo.demo.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("grocery_items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GroceryItem {

    @Id
    private String id;
    private String name;
    private int quantity;
    private String category;

}
