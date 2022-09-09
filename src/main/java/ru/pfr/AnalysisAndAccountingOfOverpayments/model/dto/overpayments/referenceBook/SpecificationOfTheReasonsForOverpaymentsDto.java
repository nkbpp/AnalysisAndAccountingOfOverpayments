package ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.referenceBook;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data //@ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpecificationOfTheReasonsForOverpaymentsDto {

    private Long id;

    private String specificationOfTheReasonsForOverpayments;

}
