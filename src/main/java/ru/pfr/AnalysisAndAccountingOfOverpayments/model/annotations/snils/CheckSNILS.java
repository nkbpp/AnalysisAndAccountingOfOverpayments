package ru.pfr.AnalysisAndAccountingOfOverpayments.model.annotations.snils;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.*;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@NotNull(message = "SNILS cannot be null")
@Pattern(regexp="(^\\d{3}-\\d{3}-\\d{3} \\d{2})", message = "Invalid SNILS format")
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = CheckSNILSValidator.class)
public @interface CheckSNILS {
    String message() default "SNILS checksum is incorrect";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}