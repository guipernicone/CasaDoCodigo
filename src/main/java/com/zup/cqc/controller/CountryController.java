package com.zup.cqc.controller;

import com.zup.cqc.entity.country.Country;
import com.zup.cqc.entity.country.form.CreateCountryForm;
import com.zup.cqc.entity.country.response.CountryResponse;
import com.zup.cqc.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<CountryResponse> createCountry(
            @RequestBody @Valid CreateCountryForm countryForm,
            UriComponentsBuilder uriBuilder) {
        Country country = countryForm.toModel();
        countryRepository.save(country);

        URI uri = uriBuilder.path("country/{id}").buildAndExpand(country.getId()).toUri();
        CountryResponse countryResponse = new CountryResponse(country);
        return ResponseEntity.created(uri).body(countryResponse);
    }
}
