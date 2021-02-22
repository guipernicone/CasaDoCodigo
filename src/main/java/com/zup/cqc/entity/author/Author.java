package com.zup.cqc.entity.author;

import com.zup.cqc.entity.author.response.AuthorResponse;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message="{NotBlank}")
    private String name;

    @NotBlank(message="{NotBlank}")
    @Email(message="{Email}")
    private String email;

    @NotBlank(message="{NotBlank}")
    @Size(max=400, message="{Size.description}")
    private String description;

    private LocalDateTime registerDate;

    @Deprecated
    public Author(){}

    public Author(String name, String email, String description){
        this.name = name;
        this.email = email;
        this.description = description;
        this.registerDate = LocalDateTime.now();
    }

    public long getId() {
        return id;
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

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

}

