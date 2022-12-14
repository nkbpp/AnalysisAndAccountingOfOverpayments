package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.findCitizen;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.district.NumDistrictDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.snils.SNILSDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Pensioner;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.citizen.PensionerMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook.DistrictMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.citizen.PensionerService;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook.DistrictService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aaaop")
public class FindCitizenControllerRest {

    private final PensionerMapper pensionerMapper;
    private final PensionerService pensionerService;

    private final DistrictMapper districtMapper;

    private final DistrictService districtService;


    @PostMapping(path ="/findCitizenSNILS", //produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findCitizenSNILSDto(@RequestBody @Valid SNILSDto snils,
                                                                  @RequestParam(defaultValue = "30") Integer col,
                                                                  @RequestParam(defaultValue = "1") Integer pagination,
                                                                  Model model) {
        try {
            List<Pensioner> pensioners = pensionerService
                    .findBySnils(snils.getSnils(), pagination, col);
            return new ResponseEntity<>(pensioners.stream()
                    .map(pensionerMapper::toDto)
                    .collect(Collectors.toList())
                    , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("??????????",HttpStatus.BAD_REQUEST);
        }

    }

/*    @PostMapping(path ="/findDependentSNILS", //produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findIjdSNILSDto(@RequestBody @Valid SNILSDto snils,
                                                 Model model) {
        try {
            List<CitizenRos> citizenRos = pensionerService
                    .findIjdBySnils(snils.getSnils());
            return new ResponseEntity<>(citizenRos.stream()
                    .map(citizen1 -> pensionerMapper.toDto(citizen1))
                    .collect(Collectors.toList())
                    , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("??????????",HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(path ="/findCarerBySnils", //produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findCarerBySnilsDto(@RequestBody @Valid SNILSDto snils,
                                             Model model) {
        try {
            List<CitizenRos> citizenRos = pensionerService
                    .findCarerBySnils(snils.getSnils());
            return new ResponseEntity<>(citizenRos.stream()
                    .map(citizen1 -> pensionerMapper.toDto(citizen1))
                    .collect(Collectors.toList())
                    , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("??????????",HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(path ="/findCitizenFIO", //produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findCitizenFIODto(@RequestBody @Valid FIODto fio,
                                              @RequestParam(defaultValue = "30") Integer col,
                                              @RequestParam(defaultValue = "1") Integer pagination,
                                              Model model) {
        try {
            List<CitizenRos> citizenRos = pensionerService
                    .findByFioAndDate(fio.getSurname(), fio.getName(), fio.getPatronymic(), fio.getDateOfBirth(), pagination, col);
            return new ResponseEntity<>(
                    citizenRos.stream()
                            .map(citizen1 -> pensionerMapper.toDto(citizen1))
                            .collect(Collectors.toList())
                    , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }*/

    @PostMapping(path ="/findCitizenDistrict")
    public ResponseEntity<?> greetingSubmit(@RequestBody @Valid
                                                NumDistrictDto district,
                                           @RequestParam(defaultValue = "30") Integer col,
                                           @RequestParam(defaultValue = "1") Integer pagination,
                                           Model model) {
        try {

            List<Pensioner> pensioners = pensionerService
                    .findByDistrict(districtService.findByKod(district.getNumDistrict()), pagination, col);
            pensionerMapper.toDto(pensioners.get(0));
            return new ResponseEntity<>(
                    pensioners.stream()
                            .map(pensioner -> pensionerMapper.toDto(pensioner))
                            .collect(Collectors.toList())
                    , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
