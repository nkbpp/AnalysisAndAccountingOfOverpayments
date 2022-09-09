package ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.citizen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddCitizenPensionerCarerDependentDto {

    private CitizenDto pensioner;

    private List<CitizenDto> carers;

    private List<CitizenDto> dependents;

}
