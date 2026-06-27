package com.blog.blog.Services;


import com.blog.blog.domain.entities.Category;
import com.blog.blog.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> listCategories(){
        return categoryRepository.findAllWithPostCount();

    }

    public  Category createCategory(Category category){
        if(categoryRepository.existByNameIgnoreCase(category.getName())){
            throw  new IllegalArgumentException("category already exist with name :"+ category.getName());
        }
        return categoryRepository.save(category);
    }
}
