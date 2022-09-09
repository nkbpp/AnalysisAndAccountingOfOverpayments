package ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CitizenRosTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory()
            .getValidator();

    @Test
    public void whenAllAcceptable() {
        CitizenRos citizenRos = new CitizenRos("1","FI","NA","OT", LocalDate.of(2020,1,1),"","","",0,"112-233-445 95");
        Set<ConstraintViolation<CitizenRos>> violations = validator.validate(citizenRos);

        assertThat(violations).isEmpty();
    }

    @Test
    public void whenAllNull() {
        CitizenRos citizenRos = new CitizenRos(null,"FI","NA","OT", LocalDate.of(2020,1,1),"","","",0,"112-233-445 95");

        Set<ConstraintViolation<CitizenRos>> violations = validator.validate(citizenRos);

        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                        testObjectConstraintViolation.getPropertyPath().toString().equals("id") &&
                                testObjectConstraintViolation.getMessage().equals("id cannot be null"));
    }

}