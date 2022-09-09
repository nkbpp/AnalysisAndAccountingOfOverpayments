package ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.citizen;

import org.springframework.stereotype.Component;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.citizen.CarerDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.citizen.PensionerDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Carer;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Pensioner;

@Component
public class CarerMapper {

    public CarerDto toDto(Carer obj) {
        return CarerDto.builder()
                .id(obj.getId())
                .snils(obj.getSnils())
                .surname(obj.getSurname())
                .name(obj.getName())
                .patronymic(obj.getPatronymic())
                .adrreg(obj.getAdrreg())
                .tel(obj.getTel())
                .build();
    }

    public Carer fromDto(CarerDto dto) {
        return Carer.builder()
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
