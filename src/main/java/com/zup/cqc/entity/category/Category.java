package com.zup.cqc.entity.category;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "{NotBlank}")
    private String name;

    @Deprecated
    public Category() {}
    public Category(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
