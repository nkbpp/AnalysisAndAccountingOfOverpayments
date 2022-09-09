package ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.citizen;

import org.springframework.stereotype.Component;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.citizen.CitizenRosDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.SuperIDFIO;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen.CitizenRos;

@Component
public class CitizenRosMapper extends SuperIDFIO {

    public CitizenRosDto toDto(CitizenRos obj) {
        return CitizenRosDto.builder()
                .id(obj.getId())
                .surname(obj.getSurname())
                .name(obj.getName())
                .patronymic(obj.getPatronymic())
                .rdat(obj.getRdat())
                .adrfakt(obj.getAdrfakt())
                .adrreg(obj.getAdrreg())
                .tel(obj.getTel())
                .district(obj.getDistrict())
                .snils(obj.getSnils())
                .build();
    }

    public CitizenRos fromDto(CitizenRosDto dto) {
        return CitizenRos.builder()
                .id(dto.getId())
                .surname(dto.getSurname())
                .name(dto.getName())
                .patronymic(dto.getPatronymic())
                .rdat(dto.getRdat())
                .adrfakt(dto.getAdrfakt())
                .adrreg(dto.getAdrreg())
                .tel(dto.getTel())
                .district(dto.getDistrict())
                .snils(dto.getSnils())
                .build();
    }


}
