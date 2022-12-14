package ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
//@SuperBuilder
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

    public SuperIDFIO(String id, String surname, String name, String patronymic) {
        super(id);
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }
}
