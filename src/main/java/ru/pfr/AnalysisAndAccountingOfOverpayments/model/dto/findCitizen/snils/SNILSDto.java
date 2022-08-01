package ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.snils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.annotations.snils.CheckSNILS;

@Data //@ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class SNILSDto {

    @CheckSNILS
    private String snils;

}
