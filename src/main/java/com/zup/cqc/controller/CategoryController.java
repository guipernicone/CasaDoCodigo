package com.zup.cqc.controller;

import com.zup.cqc.entity.category.Category;
import com.zup.cqc.entity.category.form.CreateCategoryForm;
import com.zup.cqc.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Category> createCategory(@RequestBody @Valid CreateCategoryForm categoryForm, UriComponentsBuilder uriBuilder ){
        System.out.println(categoryForm.toString());
        Category category = categoryForm.toModel();
        categoryRepository.save(category);

        URI uri = uriBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(category);
    }
}
