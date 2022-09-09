package ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.citizen;

import org.springframework.stereotype.Component;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.citizen.DependentDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Dependent;

@Component
public class DependentMapper {

    public DependentDto toDto(Dependent obj) {
        return DependentDto.builder()
                .id(obj.getId())
                .snils(obj.getSnils())
                .surname(obj.getSurname())
                .name(obj.getName())
                .patronymic(obj.getPatronymic())
                .adrreg(obj.getAdrreg())
                .tel(obj.getTel())
                .build();
    }

    public Dependent fromDto(DependentDto dto) {
        return Dependent.builder()
                .id(dto.getId())
                .snils(dto.getSnils())
                .surname(dto.getSurname())
                .name(dto.getName())
                .patronymic(dto.getPatronymic())
                .adrreg(dto.getAdrreg())
                .tel(dto.getTel())
                .build();
    }

}
