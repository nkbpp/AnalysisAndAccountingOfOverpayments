package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.referenceBook;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.referenceBook.SpecificationOfTheReasonsForOverpaymentsDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook.SpecificationOfTheReasonsForOverpaymentsMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook.SpecificationOfTheReasonsForOverpaymentsService;

@RestController
@RequestMapping("/aaaop/referenceBook")
public class SpecificationOfTheReasonsForOverpaymentsControllerRest {

    private final SpecificationOfTheReasonsForOverpaymentsService specificationOfTheReasonsForOverpaymentsService;

    private final SpecificationOfTheReasonsForOverpaymentsMapper specificationOfTheReasonsForOverpaymentsMapper;

    public SpecificationOfTheReasonsForOverpaymentsControllerRest(SpecificationOfTheReasonsForOverpaymentsService specificationOfTheReasonsForOverpaymentsService, SpecificationOfTheReasonsForOverpaymentsMapper specificationOfTheReasonsForOverpaymentsMapper) {
        this.specificationOfTheReasonsForOverpaymentsService = specificationOfTheReasonsForOverpaymentsService;
        this.specificationOfTheReasonsForOverpaymentsMapper = specificationOfTheReasonsForOverpaymentsMapper;
    }


    /**
     * Удалить
     */
    @DeleteMapping("/specificationOfTheReasonsForOverpayments/{id}")
    public ResponseEntity<?> delette(@PathVariable("id") Long id) {
        try {
            specificationOfTheReasonsForOverpaymentsService.delete(id);
            return new ResponseEntity<>("Удаление прошло успешно!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Найти по ID
     */
    @GetMapping(path = "/specificationOfTheReasonsForOverpayments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(specificationOfTheReasonsForOverpaymentsService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * Обновить тут
     */
    @PutMapping(path ="/specificationOfTheReasonsForOverpayments",
            consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> update(
            @RequestBody SpecificationOfTheReasonsForOverpaymentsDto specificationOfTheReasonsForOverpaymentsDto) {
        try {
            specificationOfTheReasonsForOverpaymentsService.update(specificationOfTheReasonsForOverpaymentsMapper.fromDto(specificationOfTheReasonsForOverpaymentsDto));
            return new ResponseEntity<>("Изменено", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Добавление
     */
    @PostMapping(path ="/specificationOfTheReasonsForOverpayments",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(
            @RequestBody SpecificationOfTheReasonsForOverpaymentsDto specificationOfTheReasonsForOverpaymentsDto) {
        try {
            specificationOfTheReasonsForOverpaymentsService.save(specificationOfTheReasonsForOverpaymentsMapper.fromDto(specificationOfTheReasonsForOverpaymentsDto));
            return new ResponseEntity<>("Добавлено", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * Получить все
     */
    @PostMapping(path = "/specificationOfTheReasonsForOverpayments/All")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "30") Integer col,
                                    @RequestParam(defaultValue = "1") Integer pagination,
                                    Model model) {
        try {
            return new ResponseEntity<>(specificationOfTheReasonsForOverpaymentsService.findAll(pagination, col), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
