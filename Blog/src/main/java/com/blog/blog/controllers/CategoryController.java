package com.blog.blog.controllers;

import com.blog.blog.Services.CategoryService;
import com.blog.blog.domain.Dtos.CategoryDto;
import com.blog.blog.domain.Dtos.CreateCategoryRequest;
import com.blog.blog.domain.entities.Category;
import com.blog.blog.mappers.CategoryMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories(){
        List<CategoryDto> categories= categoryService.listCategories()
                .stream().map(category->categoryMapper.toDto(category))
                .toList();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
             @Valid @RequestBody CreateCategoryRequest createCategoryRequest){
        Category categoryToCreate= categoryMapper.toEntity(createCategoryRequest)
        ;
        Category savedCategory=categoryService.createCategory(categoryToCreate);
        return new ResponseEntity<>(
                categoryMapper.toDto(savedCategory),
                HttpStatus.CREATED
        );
    }


}
