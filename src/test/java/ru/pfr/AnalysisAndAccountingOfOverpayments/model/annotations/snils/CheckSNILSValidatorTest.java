package ru.pfr.AnalysisAndAccountingOfOverpayments.model.annotations.snils;

import org.junit.jupiter.api.Test;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.annotations.snils.CheckSNILS;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CheckSNILSValidatorTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory()
            .getValidator();

    private class TestObject {

        @CheckSNILS
        private String snils;

        public TestObject() {
        }

        public void setSnils(String snils) {
            this.snils = snils;
        }
    }

    @Test
    public void whenAllAcceptable() {
        TestObject testObject = new TestObject();
        testObject.setSnils("112-233-445 95");

        Set<ConstraintViolation<TestObject>> violations = validator.validate(testObject);

        assertThat(violations).isEmpty();
    }

    @Test
    public void whenAllNull() {
        TestObject testObject = new TestObject();
        testObject.setSnils(null);

        Set<ConstraintViolation<TestObject>> violations = validator.validate(testObject);

        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                                testObjectConstraintViolation.getMessage().equals("SNILS cannot be null"));
    }

    @Test
    public void whenChecksumIsIncorrect() {
        TestObject testObject = new TestObject();
        testObject.setSnils("112-233-446 95");

        Set<ConstraintViolation<TestObject>> violations = validator.validate(testObject);

        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                                testObjectConstraintViolation.getMessage().equals("SNILS checksum is incorrect"));
    }

    @Test
    public void whenLengthMore() {
        TestObject testObject = new TestObject();
        testObject.setSnils("112-233-446 954");

        Set<ConstraintViolation<TestObject>> violations = validator.validate(testObject);

        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                                testObjectConstraintViolation.getMessage().equals("Invalid SNILS format"));
    }

    @Test
    public void whenLengthLess() {
        TestObject testObject = new TestObject();
        testObject.setSnils("112-233-446 9");

        Set<ConstraintViolation<TestObject>> violations = validator.validate(testObject);

        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                                testObjectConstraintViolation.getMessage().equals("Invalid SNILS format"));
    }

    @Test
    public void whenIncorrectSymbol() {
        TestObject testObject = new TestObject();
        testObject.setSnils("112-233-446 9w");

        Set<ConstraintViolation<TestObject>> violations = validator.validate(testObject);

        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                                testObjectConstraintViolation.getMessage().equals("Invalid SNILS format"));
    }

    @Test
    public void whenLessThan1001998() {
        TestObject testObject = new TestObject();
        testObject.setSnils("000-001-997 64");

        Set<ConstraintViolation<TestObject>> violations = validator.validate(testObject);

        assertThat(violations).anyMatch(
                testObjectConstraintViolation ->
                                testObjectConstraintViolation.getMessage().equals("SNILS checksum is incorrect"));
    }

    @Test
    public void whenSumMoreThan101() {
        TestObject testObject = new TestObject();
        testObject.setSnils("999-999-999 01");

        Set<ConstraintViolation<TestObject>> violations = validator.validate(testObject);

        assertThat(violations).isEmpty();
    }

}