package com.example.geradordor_de_qrcode.domain.category;

import com.example.geradordor_de_qrcode.DTO.CategoryDTO;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("categories")
@Getter
@Setter
@NoArgsConstructor


public class Category {
    @Id
    private String id;
    private String title;
    private String description;
    private String ownerId;

    public Category(CategoryDTO categoryDTO) {
        this.description = description;
        this.ownerId = ownerId;
        this.title = title;
    }
}
