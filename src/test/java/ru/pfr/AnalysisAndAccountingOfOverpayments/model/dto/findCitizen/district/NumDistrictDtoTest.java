package ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.district;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumDistrictDtoTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory()
            .getValidator();

    @Test
    public void whenAllAcceptable() {
        NumDistrictDto district = new NumDistrictDto(2);

        Set<ConstraintViolation<NumDistrictDto>> violations = validator.validate(district);

        assertThat(violations).isEmpty();
    }

    @Test
    public void whenAllNull() {
        NumDistrictDto district = new NumDistrictDto(null);

        Set<ConstraintViolation<NumDistrictDto>> violations = validator.validate(district);

        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                        testObjectConstraintViolation.getPropertyPath().toString().equals("numDistrict") &&
                                testObjectConstraintViolation.getMessage().equals("District cannot be null"));
    }

    @Test
    public void whenDistrictLessThanZero() {
        NumDistrictDto district = new NumDistrictDto(-1);

        Set<ConstraintViolation<NumDistrictDto>> violations = validator.validate(district);

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                        testObjectConstraintViolation.getPropertyPath().toString().equals("numDistrict") &&
                                testObjectConstraintViolation.getMessage().equals("Value should be greater then equal to 0"));
    }

    @Test
    public void whenDistrictMoreThanTwentySeven() {
        NumDistrictDto district = new NumDistrictDto(28);

        Set<ConstraintViolation<NumDistrictDto>> violations = validator.validate(district);

        assertThat(violations.size()).isEqualTo(1);
        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                        testObjectConstraintViolation.getPropertyPath().toString().equals("numDistrict") &&
                                testObjectConstraintViolation.getMessage().equals("Value should be less then equal to 27"));
    }

}