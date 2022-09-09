package ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook;

import org.springframework.stereotype.Component;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.referenceBook.DistrictDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.District;

@Component
public class DistrictMapper {

    public DistrictDto toDto(District obj) {
        return DistrictDto.builder()
                .id(obj.getId())
                .kod(obj.getKod())
                .name(obj.getName())
                .build();
    }

    public District fromDto(DistrictDto dto) {
        return District.builder()
                .id(dto.getId())
                .kod(dto.getKod())
                .name(dto.getName())
                .build();
    }

}
