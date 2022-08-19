package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.referenceBook;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.overpayments.referenceBook.ReasonsForOverpaymentsDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.ReasonsForOverpayments;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook.ReasonsForOverpaymentsMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook.ReasonsForOverpaymentsService;

import java.util.List;

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
    public ResponseEntity<?> deletteReasonsForOverpayments(@PathVariable("id") Long id) {
        try {
            reasonsForOverpaymentsService.delete(id);
            return new ResponseEntity<>("Удаление прошло успешно!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Найти вопрос по ID
     */
    @GetMapping(path = "/reasonsForOverpayments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReasonsForOverpayments findReasonsForOverpaymentsById(@PathVariable("id") Long id) {
        return reasonsForOverpaymentsService.findById(id);
    }


    /**
     * Обновить
     */
    @PutMapping("/reasonsForOverpayments")
    public ResponseEntity<?>updateQuest(@RequestBody ReasonsForOverpaymentsDto reasonsForOverpaymentsDto) {
        try {
            reasonsForOverpaymentsService.update(reasonsForOverpaymentsMapper.fromDto(reasonsForOverpaymentsDto));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Добавление
     */
    @PostMapping("/reasonsForOverpayments")
    public ResponseEntity addQuest(@RequestBody ReasonsForOverpaymentsDto reasonsForOverpaymentsDto) {
        reasonsForOverpaymentsService.save(reasonsForOverpaymentsMapper.fromDto(reasonsForOverpaymentsDto));
        return ResponseEntity.ok().build();
    }


    /**
     * Получить все
     */
    @PostMapping(path = "/reasonsForOverpayments/All")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "30") Integer col,
                                    @RequestParam(defaultValue = "1") Integer pagination,
                                    Model model) {
        try {
            return new ResponseEntity<>(reasonsForOverpaymentsService.findAll(pagination, col), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
