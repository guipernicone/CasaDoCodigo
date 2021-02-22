package com.zup.cqc.entity.author.response;

import com.zup.cqc.entity.author.Author;

public class AuthorDetailsWithoutEmail {
    private String name;
    private String description;

    public AuthorDetailsWithoutEmail(Author author) {
        this.name = author.getName();
        this.description = author.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
