package com.zup.cqc.entity.client.form;


import com.zup.cqc.entity.client.Client;
import com.zup.cqc.entity.country.Country;
import com.zup.cqc.entity.state.State;
import com.zup.cqc.validator.CPForCNPJ;
import com.zup.cqc.validator.UniqueValue;
import com.zup.cqc.validator.ValidCountryState;
import com.zup.cqc.validator.ValidId;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ValidCountryState(
        stateClass = State.class,
        stateIdField = "stateId",
        countryClass = Country.class,
        countryIdField = "countryId",
        countryEntityField = "country",
        message= "{ValidCountryState}"
)
public class CreateClientForm {

    @NotBlank(message = "{NotBlank}")
    private String name;
    @NotBlank(message = "{NotBlank}")
    private String surname;
    @NotBlank(message = "{NotBlank}")
    @Email(message = "{Email}")
    @UniqueValue(domainClass = Client.class, fieldName = "email")
    private String email;
    @NotBlank(message = "{NotBlank}")
    @CPForCNPJ(message= "{CPForCNPJ}")
    private String document;
    @NotBlank(message = "{NotBlank}")
    private String address;
    @NotBlank(message = "{NotBlank}")
    private String compliment;
    @NotBlank(message = "{NotBlank}")
    private String city;
    @NotNull(message = "{NotNull}")
    @ValidId(domainClass = Country.class, message ="{ValidId}")
    private Long countryId;
    private Long stateId;
    @NotBlank(message = "{NotBlank}")
    private String phone;
    @NotBlank(message = "{NotBlank}")
    private String cep;

    @Override
    public String toString() {
        return "CreateClientForm{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", document='" + document + '\'' +
                ", address='" + address + '\'' +
                ", compliment='" + compliment + '\'' +
                ", city='" + city + '\'' +
                ", countryId=" + countryId +
                ", stateId=" + stateId +
                ", phone='" + phone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getCompliment() {
        return compliment;
    }

    public String getCity() {
        return city;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }

    public Client toModel(EntityManager entityManager){
        Country country = entityManager.find(Country.class, this.countryId);
        State state = null;

        if (country == null){
            throw new EntityNotFoundException("Entity Country with id" + this.countryId + "was not found");
        }

        if (this.stateId != null){
            state = entityManager.find(State.class, this.stateId);

            if (state == null){
                throw new EntityNotFoundException("Entity State with id" + this.stateId + "was not found");
            }
        }

        return new Client(
                this.name,
                this.surname,
                this.email,
                this.document,
                this.address,
                this.compliment,
                this.city,
                country,
                state,
                this.phone,
                this.cep
        );
    }
}
