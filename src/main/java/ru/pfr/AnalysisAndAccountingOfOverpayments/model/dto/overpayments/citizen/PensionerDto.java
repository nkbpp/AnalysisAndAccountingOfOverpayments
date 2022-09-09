package ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.citizen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PensionerDto extends CitizenDto {

    private List<CarerDto> carers;

    private List<DependentDto> dependents;

    @Builder
    public PensionerDto(Long id, String snils, String surname, String name, String patronymic, String adrreg, String tel, List<CarerDto> carers, List<DependentDto> dependents) {
        super(id, snils, surname, name, patronymic, adrreg, tel);
        this.carers = carers;
        this.dependents = dependents;
    }

    public PensionerDto(String snils, String surname, String name, String patronymic, String adrreg, String tel, List<CarerDto> carers, List<DependentDto> dependents) {
        super(snils, surname, name, patronymic, adrreg, tel);
        this.carers = carers;
        this.dependents = dependents;
    }

}
