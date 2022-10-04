package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.addCitizen;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.citizen.PensionerDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Pensioner;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.citizen.PensionerMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.citizen.PensionerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aaaop/addCitizen2")
public class AddCitizenControllerRest2 {

    private final PensionerService pensionerService;

    private final PensionerMapper pensionerMapper;


    /**
     * Добавление
     */
    @PostMapping(path ="/citizen", //produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestBody PensionerDto pensionerDto) {
        try {
            Pensioner pensioner = pensionerMapper.fromDto(pensionerDto);
            pensionerService.save(pensioner);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Получить все
     */
    @PostMapping(path = "/citizen/All")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "30") Integer col,
                                    @RequestParam(defaultValue = "1") Integer pagination
                                    ) {
        try {
            return new ResponseEntity<>(pensionerService.findAll(pagination, col), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Обновить todo проверить
     */
    @PutMapping(path ="/citizen",
            consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> update(
            @RequestBody PensionerDto pensionerDto) {
        try {
            pensionerService.update(pensionerMapper.fromDto(pensionerDto));
            return new ResponseEntity<>("Изменено", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Найти ID
     */
    @GetMapping(path = "/citizen/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(pensionerService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Удалить
     */
    @DeleteMapping("/citizen/{id}")
    public ResponseEntity<?> delette(@PathVariable("id") Long id) {
        try {
            pensionerService.delete(id);
            return new ResponseEntity<>("Удаление прошло успешно!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
