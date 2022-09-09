package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.referenceBook;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.referenceBook.ReasonsForOverpaymentsDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook.ReasonsForOverpaymentsMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook.ReasonsForOverpaymentsService;

@RestController
@RequestMapping("/aaaop/referenceBook")
public class ReferenceBookControllerRest {

    private final ReasonsForOverpaymentsService reasonsForOverpaymentsService;

    private final ReasonsForOverpaymentsMapper reasonsForOverpaymentsMapper;

    public ReferenceBookControllerRest(ReasonsForOverpaymentsService reasonsForOverpaymentsService, ReasonsForOverpaymentsMapper reasonsForOverpaymentsMapper) {
        this.reasonsForOverpaymentsService = reasonsForOverpaymentsService;
        this.reasonsForOverpaymentsMapper = reasonsForOverpaymentsMapper;
    }

    /**
     * Удалить
     */
    @DeleteMapping("/reasonsForOverpayments/{id}")
    public ResponseEntity<?> delette(@PathVariable("id") Long id) {
        try {
            reasonsForOverpaymentsService.delete(id);
            return new ResponseEntity<>("Удаление прошло успешно!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Найти ID
     */
    @GetMapping(path = "/reasonsForOverpayments/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(reasonsForOverpaymentsService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * Обновить
     */
    @PutMapping(path ="/reasonsForOverpayments",
            consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> update(
            @RequestBody ReasonsForOverpaymentsDto reasonsForOverpaymentsDto) {
        try {
            reasonsForOverpaymentsService.update(reasonsForOverpaymentsMapper.fromDto(reasonsForOverpaymentsDto));
            return new ResponseEntity<>("Изменено", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Добавление
     */
    @PostMapping(path ="/reasonsForOverpayments",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(
            @RequestBody ReasonsForOverpaymentsDto reasonsForOverpaymentsDto) {
        try {
            reasonsForOverpaymentsService.save(reasonsForOverpaymentsMapper.fromDto(reasonsForOverpaymentsDto));
            return new ResponseEntity<>("Добавлено", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * Получить все
     */
    @PostMapping(path = "/reasonsForOverpayments/All")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "30") Integer col,
                                    @RequestParam(defaultValue = "1") Integer pagination) {
        try {
            return new ResponseEntity<>(reasonsForOverpaymentsService.findAll(pagination, col), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
