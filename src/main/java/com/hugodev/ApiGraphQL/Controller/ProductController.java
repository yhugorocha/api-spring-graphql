package com.hugodev.ApiGraphQL.Controller;

import com.hugodev.ApiGraphQL.dto.ProductRequest;
import com.hugodev.ApiGraphQL.entity.Product;
import com.hugodev.ApiGraphQL.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @MutationMapping
    Object addProduct(@Argument ProductRequest productRequest){
        return this.productService.saveProduct(productRequest);
    }

    @QueryMapping
    Iterable<Product> findAllproducts(){
        return this.productService.findAllProdutcs();
    }
}
