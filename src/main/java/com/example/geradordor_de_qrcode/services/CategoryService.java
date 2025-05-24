package com.example.geradordor_de_qrcode.services;

import com.example.geradordor_de_qrcode.DTO.CategoryDTO;
import com.example.geradordor_de_qrcode.domain.category.Category;
import com.example.geradordor_de_qrcode.domain.category.exceptions.CategoryNotFoundException;
import com.example.geradordor_de_qrcode.repository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category insert(CategoryDTO categoryDTO){
        Category newCategory = new Category(categoryDTO);
        this.categoryRepository.save(newCategory);
        return newCategory;
    }
    public List<Category> getAll(){
        return this.categoryRepository.findAll();
    }
    public Optional <Category> getByID(String ID){
        return this.categoryRepository.findById (ID);
    }

    public Category update(String ID ,CategoryDTO categoryDTO){
        Category category = this.categoryRepository.findById(ID).orElseThrow(CategoryNotFoundException::new);
        if (!categoryDTO.title().isEmpty()) category.setTitle(categoryDTO.title());
        if (!categoryDTO.description().isEmpty()) category.setDescription(categoryDTO.description());

        this.categoryRepository.save(category);

        return category;
    }

    public void delete(String ID){
        Category category = this.categoryRepository.findById(ID).orElseThrow(CategoryNotFoundException::new);
        this.categoryRepository.delete(category);

    }



}
