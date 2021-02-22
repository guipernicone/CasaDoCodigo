package com.zup.cqc.controller;

import com.zup.cqc.entity.category.Category;
import com.zup.cqc.entity.category.form.CreateCategoryForm;
import com.zup.cqc.entity.category.response.CategoryResponse;
import com.zup.cqc.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody @Valid CreateCategoryForm categoryForm, UriComponentsBuilder uriBuilder){
        Category category = categoryForm.toModel();
        categoryRepository.save(category);

        URI uri = uriBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri();
        CategoryResponse categoryResponse = new CategoryResponse(category);
        return ResponseEntity.created(uri).body(categoryResponse);
    }
}
