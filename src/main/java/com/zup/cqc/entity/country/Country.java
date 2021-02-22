package com.zup.cqc.entity.country;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "{NotBlank}")
    private String name;

    @Deprecated
    public Country(){}

    public Country(String name){
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
