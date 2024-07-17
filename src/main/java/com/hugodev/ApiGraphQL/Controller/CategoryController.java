package com.hugodev.ApiGraphQL.Controller;

import com.hugodev.ApiGraphQL.dto.CategoryRequest;
import com.hugodev.ApiGraphQL.entity.Category;
import com.hugodev.ApiGraphQL.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.UUID;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @MutationMapping
    Category addCategory(@Argument CategoryRequest categoryRequest){
        return categoryService.saveCategory(categoryRequest);
    }

    @QueryMapping
    Optional<Category> categoryById(@Argument UUID id){
        return this.categoryService.findById(id);
    }
}
