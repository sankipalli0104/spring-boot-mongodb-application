package spring.boot.mongo.demo.document;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document(collection = "products")
public class Product {

    private String name;
    private double price;
    private String category;
}
