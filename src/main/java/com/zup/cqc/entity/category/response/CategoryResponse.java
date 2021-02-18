package com.zup.cqc.entity.category.response;

public class CategoryResponse {
    private long id;
    private String name;

    public CategoryResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
