package ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook;

import org.springframework.stereotype.Component;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.referenceBook.ReasonsForOverpaymentsDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.ReasonsForOverpayments;

@Component
public class ReasonsForOverpaymentsMapper {

    public ReasonsForOverpaymentsDto toDto(ReasonsForOverpayments obj) {
        return ReasonsForOverpaymentsDto.builder()
                .id(obj.getId())
                .reasonsForOverpayments(obj.getReasonsForOverpayments())
                .build();
    }

    public ReasonsForOverpayments fromDto(ReasonsForOverpaymentsDto dto) {
        return ReasonsForOverpayments.builder()
                .id(dto.getId())
                .reasonsForOverpayments(dto.getReasonsForOverpayments())
                .build();
    }

}
