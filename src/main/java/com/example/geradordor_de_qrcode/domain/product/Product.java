package com.example.geradordor_de_qrcode.domain.product;

import com.example.geradordor_de_qrcode.DTO.ProductDTO;
import com.example.geradordor_de_qrcode.domain.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("product")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    private String id   ;
    private String tille;
    private String owner;
    private Category category;
    private String description;
    private Integer price;

    public Product(ProductDTO data) {
        this.tille = data.title();
        this.description = data.description();
        this.price = data.price();
        this.owner=data.ownerId();
    }


}
