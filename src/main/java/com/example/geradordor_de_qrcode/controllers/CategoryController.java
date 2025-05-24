package com.example.geradordor_de_qrcode.controllers;
import com.example.geradordor_de_qrcode.DTO.CategoryDTO;
import com.example.geradordor_de_qrcode.domain.category.Category;
import com.example.geradordor_de_qrcode.domain.category.exceptions.CategoryNotFoundException;
import com.example.geradordor_de_qrcode.services.CategoryService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controller")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDTO categoryData) {
            Category newCategory = this.categoryService.insert(categoryData);
        return ResponseEntity.ok().body(new Category());
    }


    @GetMapping()
    public ResponseEntity<List> getAll() {
        List<Category> categories = this.categoryService.getAll();
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathParam ("id") String ID, @RequestBody CategoryDTO categoryData) {
        Category newCategory = this.categoryService.update(ID,categoryData);
        return ResponseEntity.ok().body(new Category());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String ID) {
        this.categoryService.delete(ID);
        return ResponseEntity.noContent().build();
    }
}
