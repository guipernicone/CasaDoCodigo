package com.zup.cqc.entity.author.form;

import com.zup.cqc.entity.author.Author;
import com.zup.cqc.validator.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateAuthorForm {

    @NotBlank(message="{NotBlank}")
    private String name;

    @NotBlank(message="{NotBlank}")
    @Email(message="{Email}")
    @UniqueValue(fieldName="email", domainClass=Author.class, message="{UniqueValue}")
    private String email;

    @NotBlank(message="{NotBlank}")
    @Size(max=400, message="{Size.description}")
    private String description;

    public CreateAuthorForm(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public Author toModel() {
        return new Author(
                this.getName(),
                this.getEmail(),
                this.getDescription()
        );
    }
    @Override
    public String toString() {
        return "CreateAuthorForm{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

