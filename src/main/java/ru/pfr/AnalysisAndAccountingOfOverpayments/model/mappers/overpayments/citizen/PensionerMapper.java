package ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.citizen;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.citizen.PensionerDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Pensioner;

import java.util.stream.Collectors;


@RequiredArgsConstructor
@Component
public class PensionerMapper {

    private final CarerMapper carerMapper;

    private final DependentMapper dependentMapper;

    public PensionerDto toDto(Pensioner obj) {
        var carerDto = obj.getCarers().stream().map(carer ->
                carerMapper.toDto(carer)).collect(Collectors.toList());
        var dependentDto = obj.getDependents().stream().map(dependent ->
                dependentMapper.toDto(dependent)).collect(Collectors.toList());
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

        var carer = dto.getCarers().stream().map(carerDto ->
                carerMapper.fromDto(carerDto)).collect(Collectors.toList());
        var dependent = dto.getDependents().stream().map(dependentDto ->
                dependentMapper.fromDto(dependentDto)).collect(Collectors.toList());

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
                .build();
    }

}
