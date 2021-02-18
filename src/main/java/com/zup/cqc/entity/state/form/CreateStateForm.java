package com.zup.cqc.entity.state.form;

import com.zup.cqc.entity.country.Country;
import com.zup.cqc.entity.state.State;
import com.zup.cqc.validator.UniqueCountryState;
import com.zup.cqc.validator.ValidId;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@UniqueCountryState(countryIdFieldAlias = "country_id", countryIdField = "countryId", stateField = "name", countryClass = State.class)
public class CreateStateForm {

    @NotNull
    @ValidId(domainClass = Country.class, message="{ValidId}")
    private long countryId;

    @NotBlank
    private String name;

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCountryId() {
        return countryId;
    }

    public String getName() {
        return name;
    }

    public State toModel(EntityManager entityManager) {
        Country country = entityManager.find(Country.class, this.countryId);

        return new State(this.name, country);
    }
}
