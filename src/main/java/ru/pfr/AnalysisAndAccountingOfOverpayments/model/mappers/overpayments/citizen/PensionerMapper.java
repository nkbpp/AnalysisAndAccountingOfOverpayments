package ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.citizen;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.citizen.CarerDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.citizen.DependentDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.citizen.PensionerDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Carer;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Dependent;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Pensioner;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen.CitizenRos;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook.DistrictService;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.ros.CitizenRosService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Component
@Transactional
public class PensionerMapper {

    private final CarerMapper carerMapper;

    private final DependentMapper dependentMapper;
    private final CitizenRosService citizenRosService;
    private final DistrictService districtService;
    public PensionerDto toDto(Pensioner obj) {
        var carerDto = obj.getCarers()==null?
                new ArrayList<CarerDto>() :
                obj.getCarers().stream().map(carerMapper::toDto).collect(Collectors.toList());
        var dependentDto = obj.getDependents()==null?
                new ArrayList<DependentDto>() :
                obj.getDependents().stream().map(dependentMapper::toDto).collect(Collectors.toList());
        return PensionerDto.builder()
                .id(obj.getId())
                .snils(obj.getSnils())
                .surname(obj.getSurname())
                .name(obj.getName())
                .patronymic(obj.getPatronymic())
                .adrreg(obj.getAdrreg())
                .tel(obj.getTel())
                .carers(carerDto)
                .dependents(dependentDto)
                .build();
    }

    public Pensioner fromDto(PensionerDto dto) {

        var carer = dto.getCarers()==null?
                new ArrayList<Carer>() :
                dto.getCarers().stream().map(carerMapper::fromDto).collect(Collectors.toList());
        var dependent = dto.getDependents()==null?
                new ArrayList<Dependent>() :
                dto.getDependents().stream().map(dependentMapper::fromDto).collect(Collectors.toList());

        CitizenRos citizenRos = citizenRosService.findPensionerBySnils(dto.getSnils());

        return Pensioner.builder()
                .id(dto.getId())
                .snils(dto.getSnils())
                .surname(dto.getSurname())
                .name(dto.getName())
                .patronymic(dto.getPatronymic())
                .adrreg(dto.getAdrreg())
                .tel(dto.getTel())
                .carers(carer)
                .dependents(dependent)
                .district(districtService.findByKod(citizenRos.getDistrict()))
                .build();
    }

}
