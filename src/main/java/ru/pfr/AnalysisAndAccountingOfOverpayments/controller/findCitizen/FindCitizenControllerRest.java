package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.findCitizen;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.citizen.CitizenDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.district.DistrictDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.fio.FIODto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.snils.SNILSDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen.Citizen;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.citizen.CitizenMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.ros.CitizenService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aaaop")
public class FindCitizenControllerRest {

    private final CitizenMapper citizenMapper;
    private final CitizenService citizenService;

    public FindCitizenControllerRest(CitizenMapper citizenMapper, CitizenService citizenService) {
        this.citizenMapper = citizenMapper;
        this.citizenService = citizenService;
    }

    @PostMapping(path ="/findCitizenSNILS", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<CitizenDto> findCitizenSNILSDto(@RequestBody @Valid SNILSDto snils,
                                                @RequestParam(defaultValue = "30") Integer col,
                                                @RequestParam(defaultValue = "1") Integer pagination,
                                                 Model model) {
        List<Citizen> citizen = citizenService
                .findBySnils(snils.getSnils(), pagination, col);
        return citizen.stream()
                .map(citizen1 -> citizenMapper.toDto(citizen1))
                .collect(Collectors.toList());
    }

    @PostMapping(path ="/findCitizenFIO", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<CitizenDto> findCitizenFIODto(@RequestBody @Valid FIODto fio,
                                              @RequestParam(defaultValue = "30") Integer col,
                                              @RequestParam(defaultValue = "1") Integer pagination,
                                              Model model) {
        List<Citizen> citizen = citizenService
                .findByFIO(fio.getSurname(), fio.getName(), fio.getPatronymic(), pagination, col);
        return citizen.stream()
                .map(citizen1 -> citizenMapper.toDto(citizen1))
                .collect(Collectors.toList());
    }

    @PostMapping(path ="/findCitizenDistrict")
    public List<CitizenDto> greetingSubmit(@RequestBody @Valid DistrictDto district,
                                           @RequestParam(defaultValue = "30") Integer col,
                                           @RequestParam(defaultValue = "1") Integer pagination,
                                           Model model) {
        List<Citizen> citizen = citizenService
                .findByDistrict(district.getNumDistrict(), pagination, col);
        return citizen.stream()
                .map(citizen1 -> citizenMapper.toDto(citizen1))
                .collect(Collectors.toList());
    }

}
