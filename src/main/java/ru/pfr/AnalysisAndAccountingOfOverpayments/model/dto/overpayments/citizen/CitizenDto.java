package ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.citizen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitizenDto {

    private Long id;

    private String snils;

    //@NotNull(message = "surname cannot be null")
    private String surname;

    //@NotNull(message = "name cannot be null")
    private String name;

    //@NotNull(message = "patronymic cannot be null")
    private String patronymic;

    private String adrreg;

    private String tel;

    public CitizenDto(String snils, String surname, String name, String patronymic, String adrreg, String tel) {
        this.snils = snils;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.adrreg = adrreg;
        this.tel = tel;
    }

}
