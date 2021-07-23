package com.br.proposta.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotExistsValidator.class)
public @interface NotExists {

    Class<?> domainClass();

    String fieldName();

    String message() default "Nao existe um objeto com o Id informado";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}