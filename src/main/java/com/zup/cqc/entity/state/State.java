package com.zup.cqc.entity.state;

import com.zup.cqc.entity.country.Country;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "state")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String name;

    @NotNull
    @ManyToOne
    private Country country;

    @Deprecated
    public State(){}

    public State(String name, Country country){
        this.name = name;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }
}
