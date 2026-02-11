package br.com.bancodigital.mscliente.adapter.in.web.dto.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CepValidator.class)
@Documented
public @interface Cep {
    String message() default "CEP em formato inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
