package com.example.jewel.jewelcontroller;

import com.example.jewel.jewelmodel.Category;
import com.example.jewel.jewelservices.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Get all categories for a jewel type
    @GetMapping("/jeweltype/{jewelTypeId}")
    public List<Category> getCategoriesByJewelType(@PathVariable("jewelTypeId") int jewel_type_id) {
        return categoryService.getCategoriesByJewelType(jewel_type_id);
    }
}

