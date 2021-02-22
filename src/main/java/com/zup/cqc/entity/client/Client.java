package com.zup.cqc.entity.client;

import com.zup.cqc.entity.country.Country;
import com.zup.cqc.entity.state.State;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "{NotBlank}")
    private String name;
    @NotBlank(message = "{NotBlank}")
    private String surname;
    @NotBlank(message = "{NotBlank}")
    @Email(message = "{Email}")
    private String email;
    @NotBlank(message = "{NotBlank}")
    private String document;
    @NotBlank(message = "{NotBlank}")
    private String address;
    @NotBlank(message = "{NotBlank}")
    private String compliment;
    @NotBlank(message = "{NotBlank}")
    private String city;
    @NotNull(message = "{NotNull}")
    @ManyToOne
    private Country country;
    @ManyToOne
    private State state;
    @NotBlank(message = "{NotBlank}")
    private String phone;
    @NotBlank(message = "{NotBlank}")
    private String cep;

    @Deprecated
    public Client() {}

    public Client(
            String name,
            String surname,
            String email,
            String document,
            String address,
            String compliment,
            String city,
            Country country,
            State state,
            String phone,
            String cep
    ) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.document = document;
        this.address = address;
        this.compliment = compliment;
        this.city = city;
        this.country = country;
        this.state = state;
        this.phone = phone;
        this.cep = cep;
    }

    public long getId() {
        return id;
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

    public Country getCountry() {
        return country;
    }

    public State getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }
}
