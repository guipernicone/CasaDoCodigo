package com.zup.cqc.validator;

import org.springframework.beans.BeanWrapperImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidCountryStateValidator implements ConstraintValidator<ValidCountryState, Object> {

    private Class<?> stateClass;
    private String stateIdField;
    private Class<?> countryClass;
    private String countryIdField;
    private String countryEntityField;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void initialize(ValidCountryState params) {
        this.stateClass = params.stateClass();
        this.stateIdField = params.stateIdField();
        this.countryClass = params.countryClass();
        this.countryIdField = params.countryIdField();
        this.countryEntityField = params.countryEntityField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("select a.id from " + this.stateClass.getName() + " a inner join " +
                this.countryClass.getName() + " b on a." +countryEntityField+ ".id = b.id where b.id = :countryId");

        query.setParameter("countryId",new BeanWrapperImpl(value).getPropertyValue(countryIdField));
        List<?> list = query.getResultList();

        if (list.isEmpty()){
            return new BeanWrapperImpl(value).getPropertyValue(stateIdField) == null;
        }
        return list.contains(new BeanWrapperImpl(value).getPropertyValue(stateIdField));
    }

}
