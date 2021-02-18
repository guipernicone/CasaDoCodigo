package com.zup.cqc.validator;

import org.springframework.beans.BeanWrapperImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueCountryStateValidator implements ConstraintValidator<UniqueCountryState, Object> {
    private String stateField;
    private String countryIdField;
    private String countryIdFieldAlias;
    private Class<?> countryClass;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueCountryState params) {
        this.stateField = params.stateField();
        this.countryIdField = params.countryIdField();
        this.countryIdFieldAlias = params.countryIdFieldAlias();
        this.countryClass = params.countryClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("select " + stateField + " from " + countryClass.getName() +"  where " + countryIdFieldAlias + "=:value");
        query.setParameter("value",new BeanWrapperImpl(value).getPropertyValue(countryIdField));
        List<?> list = query.getResultList();
        return list.isEmpty();
    }
}
