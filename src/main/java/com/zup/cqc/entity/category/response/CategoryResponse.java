package com.zup.cqc.entity.category.response;

import com.zup.cqc.entity.category.Category;

public class CategoryResponse {
    private long id;
    private String name;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
