package com.zup.cqc.entity.client.response;

import com.zup.cqc.entity.client.Client;
import com.zup.cqc.entity.country.response.CountryResponse;
import com.zup.cqc.entity.state.response.StateResponse;


public class ClientResponse {

    private String name;
    private String surname;
    private String email;
    private String document;
    private String address;
    private String compliment;
    private String city;
    private CountryResponse country;
    private StateResponse state;
    private String phone;
    private String cep;

    public ClientResponse(Client client) {

        this.name = client.getName();
        this.surname = client.getSurname();
        this.email = client.getEmail();
        this.document = client.getDocument();
        this.address = client.getAddress();
        this.compliment = client.getCompliment();
        this.city = client.getCity();
        this.country = new CountryResponse(client.getCountry());
        if (client.getState() == null){
            this.state = null;
        }
        else{
            this.state = new StateResponse(client.getState());
        }
        this.phone = client.getPhone();
        this.cep = client.getCep();
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

    public CountryResponse getCountry() {
        return country;
    }

    public StateResponse getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }
}
