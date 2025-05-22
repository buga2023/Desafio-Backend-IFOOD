package com.example.geradordor_de_qrcode.repository;

import com.example.geradordor_de_qrcode.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
