package ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.fio;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.annotations.fio.CustomDateDeserializerRuAndEn;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class FIODto {

    @NotNull(message = "surname cannot be null")
    private String surname;
    @NotNull(message = "name cannot be null")
    private String name;
    @NotNull(message = "patronymic cannot be null")
    private String patronymic;
    @NotNull(message = "dateOfBirth cannot be null")
    @JsonDeserialize(using = CustomDateDeserializerRuAndEn.class)
    private LocalDate dateOfBirth;

    public FIODto() {
    }

    public FIODto(String surname, String name, String patronymic, LocalDate dateOfBirth) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
