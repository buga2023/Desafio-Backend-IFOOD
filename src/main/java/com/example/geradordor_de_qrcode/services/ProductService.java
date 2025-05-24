package com.example.geradordor_de_qrcode.services;

import com.example.geradordor_de_qrcode.DTO.CategoryDTO;
import com.example.geradordor_de_qrcode.DTO.ProductDTO;
import com.example.geradordor_de_qrcode.domain.category.Category;
import com.example.geradordor_de_qrcode.domain.category.exceptions.CategoryNotFoundException;
import com.example.geradordor_de_qrcode.domain.category.exceptions.ProductNotFoundException;
import com.example.geradordor_de_qrcode.domain.product.Product;
import com.example.geradordor_de_qrcode.repository.CategoryRepository;
import com.example.geradordor_de_qrcode.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private CategoryService categoryService;
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public ProductService(CategoryRepository categoryRepository ,ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public Product insert(ProductDTO productDTO) {
        Category category = this.categoryService.getByID(productDTO.categoryId()).orElseThrow(CategoryNotFoundException::new);
        Product newProduct = new Product(productDTO);
        this.productRepository.save(newProduct);
        return newProduct;
    }

    public List<Product> getAll(){
        return this.productRepository.findAll();
    }

    public Product update(String ID ,ProductDTO productDTO) {
        Product product = this.productRepository.findById(ID).orElseThrow(ProductNotFoundException::new);

            this.categoryService.getByID(productDTO.categoryId()).ifPresent(product::setCategory);

        if (!productDTO.title().isEmpty()) product.setTille(productDTO.title());
        if (!productDTO.description().isEmpty()) product.setDescription(productDTO.description());
        if (!productDTO.description().isEmpty()) product.setPrice(productDTO.price());

        this.productRepository.save(product);

        return product;
    }

    public void delete(String ID){
        Product product = this.productRepository.findById(ID).orElseThrow(CategoryNotFoundException::new);
        this.productRepository.delete(product);

    }
}
