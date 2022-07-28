package ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.fio;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class FIODtoTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory()
            .getValidator();

    @Test
    public void whenAllAcceptable() {
        FIODto fio = new FIODto(
                "Братчин",
                "Александр",
                "Владимирович",
                LocalDate.of(2022, 7, 22));

        Set<ConstraintViolation<FIODto>> violations = validator.validate(fio);

        assertThat(violations).isEmpty();
    }

    @Test
    public void whenAllNull() {
        FIODto fio = new FIODto(
                null,
                null,
                null,
                null);

        Set<ConstraintViolation<FIODto>> violations = validator.validate(fio);

        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                        testObjectConstraintViolation.getPropertyPath().toString().equals("surname") &&
                            testObjectConstraintViolation.getMessage().contains("cannot be null"));
        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                        testObjectConstraintViolation.getPropertyPath().toString().equals("name") &&
                                testObjectConstraintViolation.getMessage().contains("cannot be null"));
        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                        testObjectConstraintViolation.getPropertyPath().toString().equals("patronymic") &&
                                testObjectConstraintViolation.getMessage().contains("cannot be null"));
        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                        testObjectConstraintViolation.getPropertyPath().toString().equals("dateOfBirth") &&
                                testObjectConstraintViolation.getMessage().contains("cannot be null"));
    }

}