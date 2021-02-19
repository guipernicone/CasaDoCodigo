package com.zup.cqc.entity.country.form;

import com.zup.cqc.entity.country.Country;
import com.zup.cqc.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CreateCountryForm {

    @NotBlank(message = "{NotBlank}")
    @UniqueValue(fieldName = "name", domainClass = Country.class, message="{UniqueValue}")
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Country toModel(){
        return new Country(this.name);
    }
}
