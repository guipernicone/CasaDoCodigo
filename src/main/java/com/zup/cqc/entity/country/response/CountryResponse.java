package com.zup.cqc.entity.country.response;

import com.zup.cqc.entity.country.Country;

public class CountryResponse {

    private Long id;
    private String name;

    public CountryResponse(Country country) {
        this.id = country.getId();
        this.name = country.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
