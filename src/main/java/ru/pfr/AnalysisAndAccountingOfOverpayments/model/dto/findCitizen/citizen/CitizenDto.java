package ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.citizen;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.annotations.district.District;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.annotations.fio.CustomDateDeserializerRuAndEn;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.fio.FIODto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.SuperIDFIO;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CitizenDto {

    @NotNull(message = "id cannot be null")
    String id;

    @NotNull(message = "surname cannot be null")
    private String surname;

    @NotNull(message = "name cannot be null")
    private String name;

    @NotNull(message = "patronymic cannot be null")
    private String patronymic;

    @JsonDeserialize(using = CustomDateDeserializerRuAndEn.class)
    private LocalDate rdat;

    private String adrfakt;

    private String adrreg;

    private String tel;

    @District
    private Integer district;

    private String snils;

}
