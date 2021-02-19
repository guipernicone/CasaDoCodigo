package com.zup.cqc.entity.state.response;

import com.zup.cqc.entity.country.response.CountryResponse;
import com.zup.cqc.entity.state.State;

public class StateResponse {

    private long id;
    private String name;
    private CountryResponse country;

    public StateResponse(State state){
        this.id = state.getId();
        this.name = state.getName();
        this.country = new CountryResponse(state.getCountry());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CountryResponse getCountry() {
        return country;
    }
}
