package com.zup.cqc.validator;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CPF
@CNPJ
public class CPForCNPJValidator implements ConstraintValidator<CPForCNPJ, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        if(isCPF(value) || isCNPJ(value)){
            System.out.println("True");

            return true;
        }
        System.out.println("False");
        return false;
    }

    private boolean isCPF(Object value){
        Pattern cpf = Pattern.compile("([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}-[0-9]{2})|([0-9]{11})");
        Matcher matcher = cpf.matcher((CharSequence) value);
        return matcher.matches();
    }

    private boolean isCNPJ(Object value){
        Pattern cnpj = Pattern.compile("([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2})");
        Matcher matcher = cnpj.matcher((CharSequence) value);
        return matcher.matches();
    }
}
