package ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.citizen;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.citizen.CarerDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Carer;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen.CitizenRos;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook.DistrictService;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.ros.CitizenRosService;

@Component
@RequiredArgsConstructor
public class CarerMapper {
    private final CitizenRosService citizenRosService;
    private final DistrictService districtService;

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

        CitizenRos citizenRos = citizenRosService.findBySnils(dto.getSnils())
                .stream()
                .filter(citizenRos1 ->
                        citizenRos1.getName().equalsIgnoreCase(dto.getName()) &&
                                citizenRos1.getSurname().equalsIgnoreCase(dto.getSurname()) &&
                                citizenRos1.getPatronymic().equalsIgnoreCase(dto.getPatronymic())
                ).findFirst().orElse(new CitizenRos());

        return Carer.builder()
                .id(dto.getId())
                .snils(dto.getSnils())
                .surname(dto.getSurname())
                .name(dto.getName())
                .patronymic(dto.getPatronymic())
                .adrreg(dto.getAdrreg())
                .tel(dto.getTel())
                .district(districtService.findByKod(citizenRos.getDistrict()))
                .build();
    }

}
