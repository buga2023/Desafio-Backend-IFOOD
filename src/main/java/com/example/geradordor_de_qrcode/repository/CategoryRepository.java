package com.example.geradordor_de_qrcode.repository;

import com.example.geradordor_de_qrcode.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category,String> {
}
