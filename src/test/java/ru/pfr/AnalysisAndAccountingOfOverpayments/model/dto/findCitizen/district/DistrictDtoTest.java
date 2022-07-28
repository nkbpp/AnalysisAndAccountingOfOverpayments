package ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.district;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class DistrictDtoTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory()
            .getValidator();

    @Test
    public void whenAllAcceptable() {
        DistrictDto district = new DistrictDto(2);

        Set<ConstraintViolation<DistrictDto>> violations = validator.validate(district);

        assertThat(violations).isEmpty();
    }

    @Test
    public void whenAllNull() {
        DistrictDto district = new DistrictDto(null);

        Set<ConstraintViolation<DistrictDto>> violations = validator.validate(district);

        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                        testObjectConstraintViolation.getPropertyPath().toString().equals("numDistrict") &&
                                testObjectConstraintViolation.getMessage().equals("District cannot be null"));
    }

    @Test
    public void whenDistrictLessThanZero() {
        DistrictDto district = new DistrictDto(-1);

        Set<ConstraintViolation<DistrictDto>> violations = validator.validate(district);

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                        testObjectConstraintViolation.getPropertyPath().toString().equals("numDistrict") &&
                                testObjectConstraintViolation.getMessage().equals("Value should be greater then equal to 0"));
    }

    @Test
    public void whenDistrictMoreThanTwentySeven() {
        DistrictDto district = new DistrictDto(28);

        Set<ConstraintViolation<DistrictDto>> violations = validator.validate(district);

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                        testObjectConstraintViolation.getPropertyPath().toString().equals("numDistrict") &&
                                testObjectConstraintViolation.getMessage().equals("Value should be less then equal to 27"));
    }

}