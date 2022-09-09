package ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.citizen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
public class DependentDto extends CitizenDto {

    @Builder
    public DependentDto(Long id, String snils, String surname, String name, String patronymic, String adrreg, String tel) {
        super(id, snils, surname, name, patronymic, adrreg, tel);
    }

    public DependentDto(String snils, String surname, String name, String patronymic, String adrreg, String tel) {
        super(snils, surname, name, patronymic, adrreg, tel);
    }
}
