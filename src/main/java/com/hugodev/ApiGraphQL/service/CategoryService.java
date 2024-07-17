package com.hugodev.ApiGraphQL.service;

import com.hugodev.ApiGraphQL.Repository.CategoryRepository;
import com.hugodev.ApiGraphQL.dto.CategoryRequest;
import com.hugodev.ApiGraphQL.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category saveCategory(CategoryRequest categoryRequest){
        return this.categoryRepository.save(new Category(categoryRequest.name()));
    }

    public Optional<Category> findById(UUID id) {
        return this.categoryRepository.findById(id);
    }
}
