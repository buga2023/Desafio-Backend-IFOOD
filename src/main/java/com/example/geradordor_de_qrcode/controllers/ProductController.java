package com.example.geradordor_de_qrcode.controllers;

import com.example.geradordor_de_qrcode.DTO.CategoryDTO;
import com.example.geradordor_de_qrcode.DTO.ProductDTO;
import com.example.geradordor_de_qrcode.domain.category.Category;
import com.example.geradordor_de_qrcode.domain.category.exceptions.CategoryNotFoundException;
import com.example.geradordor_de_qrcode.domain.product.Product;
import com.example.geradordor_de_qrcode.repository.CategoryRepository;
import com.example.geradordor_de_qrcode.services.CategoryService;
import com.example.geradordor_de_qrcode.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;

    private ProductService  service;

    public  ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productDTO) {
        Product newProduct = this.service.insert(productDTO);
        return ResponseEntity.ok().body(newProduct);
    }


    @GetMapping()
    public ResponseEntity<List> getAll() {
        List<Product> products = this.service.getAll();
        return ResponseEntity.ok().body(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathParam ("id") String ID, @RequestBody ProductDTO productDTO) {
        Product newProduct = this.service.update(ID,productDTO);
        return ResponseEntity.ok().body(newProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String ID) {
        this.service.delete(ID);
        return ResponseEntity.noContent().build();
    }
}
