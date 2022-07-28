package ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class SuperIDFIO extends SuperID{

    @NotNull(message = "surname cannot be null")
    @Column(name = "FA")
    private String surname;
    @NotNull(message = "name cannot be null")
    @Column(name = "IM")
    private String name;
    @NotNull(message = "patronymic cannot be null")
    @Column(name = "OT")
    private String patronymic;

    public SuperIDFIO() {
    }

    public SuperIDFIO(String id, String surname, String name, String patronymic) {
        super(id);
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
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
}
