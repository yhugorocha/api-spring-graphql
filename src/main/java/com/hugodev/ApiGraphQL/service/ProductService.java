package com.hugodev.ApiGraphQL.service;

import com.hugodev.ApiGraphQL.Repository.ProductRepository;
import com.hugodev.ApiGraphQL.dto.ProductRequest;
import com.hugodev.ApiGraphQL.entity.Category;
import com.hugodev.ApiGraphQL.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductRepository productRepository;

    public Object saveProduct(ProductRequest productRequest) {
        Optional<Category> category = this.categoryService.findById(productRequest.categoryId());

        if(category.isPresent()){
            return this.productRepository.save(new Product(productRequest.name(), productRequest.price(), category.get()));
        }

        return new Exception("Not Found");
    }

    public Iterable<Product> findAllProdutcs() {
        return this.productRepository.findAll();
    }
}
