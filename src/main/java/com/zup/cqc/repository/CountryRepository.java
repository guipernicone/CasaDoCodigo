package com.zup.cqc.repository;

import com.zup.cqc.entity.country.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
}
