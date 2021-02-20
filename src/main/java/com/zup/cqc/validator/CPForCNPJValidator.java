package com.zup.cqc.validator;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern cpf0 = Pattern.compile("^(?:(?!111\\.?111\\.?111-?11).)*$");
        Pattern cpf1 = Pattern.compile("^(?:(?!222\\.?222\\.?222-?22).)*$");
        Pattern cpf2 = Pattern.compile("^(?:(?!333\\.?333\\.?333-?33).)*$");
        Pattern cpf3 = Pattern.compile("^(?:(?!444\\.?444\\.?444-?44).)*$");
        Pattern cpf4 = Pattern.compile("^(?:(?!000\\.?000\\.?000-?00).)*$");
        Pattern cpf5 = Pattern.compile("^(?:(?!555\\.?555\\.?555-?55).)*$");
        Pattern cpf6 = Pattern.compile("^(?:(?!666\\.?666\\.?666-?66).)*$");
        Pattern cpf7 = Pattern.compile("^(?:(?!777\\.?777\\.?777-?77).)*$");
        Pattern cpf8 = Pattern.compile("^(?:(?!888\\.?888\\.?888-?88).)*$");
        Pattern cpf9 = Pattern.compile("^(?:(?!999\\.?999\\.?999-?99).)*$");

        Matcher matcher = cpf.matcher((CharSequence) value);
        Matcher matcher0 = cpf0.matcher((CharSequence) value);
        Matcher matcher1 = cpf1.matcher((CharSequence) value);
        Matcher matcher2 = cpf2.matcher((CharSequence) value);
        Matcher matcher3 = cpf3.matcher((CharSequence) value);
        Matcher matcher4 = cpf4.matcher((CharSequence) value);
        Matcher matcher5 = cpf5.matcher((CharSequence) value);
        Matcher matcher6 = cpf6.matcher((CharSequence) value);
        Matcher matcher7 = cpf7.matcher((CharSequence) value);
        Matcher matcher8 = cpf8.matcher((CharSequence) value);
        Matcher matcher9 = cpf9.matcher((CharSequence) value);

        System.out.println("CPF " + matcher.matches());
        return
                matcher.matches()
                && matcher0.matches()
                && matcher1.matches()
                && matcher2.matches()
                && matcher3.matches()
                && matcher4.matches()
                && matcher5.matches()
                && matcher6.matches()
                && matcher7.matches()
                && matcher8.matches()
                && matcher9.matches();
    }

    private boolean isCNPJ(Object value){
        Pattern cnpj = Pattern.compile("([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2})");
        Matcher matcher = cnpj.matcher((CharSequence) value);
        System.out.println("CNPJ " + matcher.matches());
        return matcher.matches();
    }
}
