package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.findCitizen;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.district.DistrictDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.fio.FIODto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.snils.SNILSDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen.CitizenRos;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.citizen.CitizenRosMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.ros.CitizenRosService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aaaop")
public class FindCitizenControllerRest {

    private final CitizenRosMapper citizenRosMapper;
    private final CitizenRosService citizenRosService;

    public FindCitizenControllerRest(CitizenRosMapper citizenRosMapper, CitizenRosService citizenRosService) {
        this.citizenRosMapper = citizenRosMapper;
        this.citizenRosService = citizenRosService;
    }

    @PostMapping(path ="/findCitizenSNILS", //produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findCitizenSNILSDto(@RequestBody @Valid SNILSDto snils,
                                                                  @RequestParam(defaultValue = "30") Integer col,
                                                                  @RequestParam(defaultValue = "1") Integer pagination,
                                                                  Model model) {
        try {
            List<CitizenRos> citizenRos = citizenRosService
                    .findBySnils(snils.getSnils(), pagination, col);
            return new ResponseEntity<>(citizenRos.stream()
                    .map(citizen1 -> citizenRosMapper.toDto(citizen1))
                    .collect(Collectors.toList())
                    , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("снилс",HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(path ="/findCitizenFIO", //produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findCitizenFIODto(@RequestBody @Valid FIODto fio,
                                              @RequestParam(defaultValue = "30") Integer col,
                                              @RequestParam(defaultValue = "1") Integer pagination,
                                              Model model) {
        try {
            List<CitizenRos> citizenRos = citizenRosService
                    .findByFioAndDate(fio.getSurname(), fio.getName(), fio.getPatronymic(), fio.getDateOfBirth(), pagination, col);
            return new ResponseEntity<>(
                    citizenRos.stream()
                            .map(citizen1 -> citizenRosMapper.toDto(citizen1))
                            .collect(Collectors.toList())
                    , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(path ="/findCitizenDistrict")
    public ResponseEntity<?> greetingSubmit(@RequestBody @Valid DistrictDto district,
                                           @RequestParam(defaultValue = "30") Integer col,
                                           @RequestParam(defaultValue = "1") Integer pagination,
                                           Model model) {
        try {
            List<CitizenRos> citizenRos = citizenRosService
                    .findByDistrict(district.getNumDistrict(), pagination, col);
            return new ResponseEntity<>(
                    citizenRos.stream()
                            .map(citizen1 -> citizenRosMapper.toDto(citizen1))
                            .collect(Collectors.toList())
                    , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
