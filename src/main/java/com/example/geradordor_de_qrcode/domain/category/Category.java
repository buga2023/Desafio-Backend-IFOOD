package com.example.geradordor_de_qrcode.domain.category;

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

}
