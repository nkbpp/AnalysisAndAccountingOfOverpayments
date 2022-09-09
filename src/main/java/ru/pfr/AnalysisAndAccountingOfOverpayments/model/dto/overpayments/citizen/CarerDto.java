package ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.citizen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
public class CarerDto extends CitizenDto {

    @Builder
    public CarerDto(Long id, String snils, String surname, String name, String patronymic, String adrreg, String tel) {
        super(id, snils, surname, name, patronymic, adrreg, tel);
    }

    public CarerDto(String snils, String surname, String name, String patronymic, String adrreg, String tel) {
        super(snils, surname, name, patronymic, adrreg, tel);
    }
}
