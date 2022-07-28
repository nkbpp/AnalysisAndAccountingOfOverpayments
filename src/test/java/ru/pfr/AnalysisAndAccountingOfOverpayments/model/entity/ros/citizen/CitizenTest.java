package ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CitizenTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory()
            .getValidator();

    @Test
    public void whenAllAcceptable() {
        Citizen citizen = new Citizen("1","FI","NA","OT", LocalDate.of(2020,1,1),"","","",0,"112-233-445 95");
        Set<ConstraintViolation<Citizen>> violations = validator.validate(citizen);

        assertThat(violations).isEmpty();
    }

    @Test
    public void whenAllNull() {
        Citizen citizen = new Citizen(null,"FI","NA","OT", LocalDate.of(2020,1,1),"","","",0,"112-233-445 95");

        Set<ConstraintViolation<Citizen>> violations = validator.validate(citizen);

        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                        testObjectConstraintViolation.getPropertyPath().toString().equals("id") &&
                                testObjectConstraintViolation.getMessage().equals("id cannot be null"));
    }

}