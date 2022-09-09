package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.referenceBook;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.referenceBook.DepartmentDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.referenceBook.ReasonsForOverpaymentsDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook.DepartmentMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook.DepartmentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aaaop/referenceBook")
public class DepartmentControllerRest {

    private final DepartmentService departmentService;

    private final DepartmentMapper departmentMapper;

    /**
     * Удалить
     */
    @DeleteMapping("/department/{id}")
    public ResponseEntity<?> delette(@PathVariable("id") Long id) {
        try {
            departmentService.delete(id);
            return new ResponseEntity<>("Удаление прошло успешно!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Найти ID
     */
    @GetMapping(path = "/department/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(departmentService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Обновить
     */
    @PutMapping(path ="/department",
            consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> update(
            @RequestBody DepartmentDto departmentDto) {
        try {
            departmentService.update(departmentMapper.fromDto(departmentDto));
            return new ResponseEntity<>("Изменено", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Добавление
     */
    @PostMapping(path ="/department",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(
            @RequestBody DepartmentDto departmentDto) {
        try {
            departmentService.save(departmentMapper.fromDto(departmentDto));
            return new ResponseEntity<>("Добавлено", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Получить все
     */
    @PostMapping(path = "/department/All")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "30") Integer col,
                                    @RequestParam(defaultValue = "1") Integer pagination) {
        try {
            return new ResponseEntity<>(departmentService.findAll(pagination, col), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
