package ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.citizen;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.stereotype.Component;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.annotations.district.District;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.annotations.fio.CustomDateDeserializerRuAndEn;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.citizen.CitizenDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.SuperIDFIO;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen.Citizen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Component
public class CitizenMapper extends SuperIDFIO {

    public CitizenDto toDto(Citizen obj) {
        return CitizenDto.builder()
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

    public Citizen fromDto(CitizenDto dto) {
        return Citizen.builder()
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
