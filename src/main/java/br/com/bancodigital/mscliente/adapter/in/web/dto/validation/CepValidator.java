package br.com.bancodigital.mscliente.adapter.in.web.dto.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CepValidator implements ConstraintValidator<Cep, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        if(value == null) return false;
        return value.matches("^\\d{8}$");
    }
}
