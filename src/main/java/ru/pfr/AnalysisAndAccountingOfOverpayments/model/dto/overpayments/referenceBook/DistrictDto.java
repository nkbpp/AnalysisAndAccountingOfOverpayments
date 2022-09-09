package ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.referenceBook;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //@ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DistrictDto {

    private Long id;

    private Integer kod;

    private String name;

}
