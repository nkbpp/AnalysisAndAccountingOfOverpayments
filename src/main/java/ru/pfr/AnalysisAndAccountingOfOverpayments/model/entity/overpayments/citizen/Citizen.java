package ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.annotations.snils.CheckSNILS;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.District;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "id cannot be null")
    private Long id;

    @CheckSNILS
    private String snils;

    @NotNull(message = "surname cannot be null")
    private String surname;

    @NotNull(message = "name cannot be null")
    private String name;

    private String patronymic;

    private String adrreg;

    private String tel;

    @ManyToOne(/*fetch = FetchType.LAZY, */cascade = CascadeType.REMOVE)
    private District district;

    public Citizen(String snils, String surname, String name, String patronymic, String adrreg, String tel, District district) {
        this.snils = snils;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.adrreg = adrreg;
        this.tel = tel;
        this.district = district;
    }
}
