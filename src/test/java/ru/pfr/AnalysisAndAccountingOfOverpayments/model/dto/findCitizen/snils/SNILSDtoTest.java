package ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.snils;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SNILSDtoTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory()
            .getValidator();

    @Test
    public void whenAllAcceptable() {
        SNILSDto snilsDto = new SNILSDto("112-233-445 95");

        Set<ConstraintViolation<SNILSDto>> violations = validator.validate(snilsDto);

        assertThat(violations).isEmpty();
    }

    @Test
    public void whenAllNull() {
        SNILSDto snilsDto = new SNILSDto(null);

        Set<ConstraintViolation<SNILSDto>> violations = validator.validate(snilsDto);

        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                        testObjectConstraintViolation.getPropertyPath().toString().equals("snils") &&
                                testObjectConstraintViolation.getMessage().equals("SNILS cannot be null"));
    }

    @Test
    public void whenChecksumIsIncorrect() {
        SNILSDto snilsDto = new SNILSDto("112-233-446 95");

        Set<ConstraintViolation<SNILSDto>> violations = validator.validate(snilsDto);

        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                        testObjectConstraintViolation.getPropertyPath().toString().equals("snils") &&
                                testObjectConstraintViolation.getMessage().equals("SNILS checksum is incorrect"));
    }

    @Test
    public void whenLengthMore() {
        SNILSDto snilsDto = new SNILSDto("112-233-446 954");

        Set<ConstraintViolation<SNILSDto>> violations = validator.validate(snilsDto);

        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                        testObjectConstraintViolation.getPropertyPath().toString().equals("snils") &&
                                testObjectConstraintViolation.getMessage().equals("Invalid SNILS format"));
    }

    @Test
    public void whenLengthLess() {
        SNILSDto snilsDto = new SNILSDto("112-233-446 9");

        Set<ConstraintViolation<SNILSDto>> violations = validator.validate(snilsDto);

        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                        testObjectConstraintViolation.getPropertyPath().toString().equals("snils") &&
                                testObjectConstraintViolation.getMessage().equals("Invalid SNILS format"));
    }

    @Test
    public void whenIncorrectSymbol() {
        SNILSDto snilsDto = new SNILSDto("112-233-446 9w");

        Set<ConstraintViolation<SNILSDto>> violations = validator.validate(snilsDto);

        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                        testObjectConstraintViolation.getPropertyPath().toString().equals("snils") &&
                                testObjectConstraintViolation.getMessage().equals("Invalid SNILS format"));
    }

    @Test
    public void whenLessThan1001998() {
        SNILSDto snilsDto = new SNILSDto("000-001-997 64");

        Set<ConstraintViolation<SNILSDto>> violations = validator.validate(snilsDto);

        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                        testObjectConstraintViolation.getPropertyPath().toString().equals("snils") &&
                                testObjectConstraintViolation.getMessage().equals("SNILS checksum is incorrect"));
    }

    @Test
    public void whenSumMoreThan101() {
        SNILSDto snilsDto = new SNILSDto("999-999-999 01");

        Set<ConstraintViolation<SNILSDto>> violations = validator.validate(snilsDto);

        assertThat(violations).isEmpty();
    }

}