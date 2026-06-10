package com.example.jewel.jewelcontroller;

import com.example.jewel.jewelmodel.Product;
import com.example.jewel.jewelservices.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private final ProductService productService;
    public ProductController(ProductService productService){this.productService=productService;}


    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable("categoryId") int category_id) {
        return productService.getProductsByCategory(category_id);
    }
    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable("productId")int id) {
        return productService.getProductById(id);
    }
}

