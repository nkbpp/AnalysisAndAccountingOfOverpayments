package ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.overpayments.referenceBook.ReasonsForOverpaymentsDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.overpayments.referenceBook.SpecificationOfTheReasonsForOverpaymentsDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.ReasonsForOverpayments;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.SpecificationOfTheReasonsForOverpayments;

@Component
public class SpecificationOfTheReasonsForOverpaymentsMapper {

    public SpecificationOfTheReasonsForOverpaymentsDto toDto(SpecificationOfTheReasonsForOverpayments obj) {
        return SpecificationOfTheReasonsForOverpaymentsDto.builder()
                .id(obj.getId())
                .specificationOfTheReasonsForOverpayments(obj.getSpecificationOfTheReasonsForOverpayments())
                .build();
    }

    public SpecificationOfTheReasonsForOverpayments fromDto(SpecificationOfTheReasonsForOverpaymentsDto dto) {
        return SpecificationOfTheReasonsForOverpayments.builder()
                .id(dto.getId())
                .specificationOfTheReasonsForOverpayments(dto.getSpecificationOfTheReasonsForOverpayments())
                .build();
    }

}
