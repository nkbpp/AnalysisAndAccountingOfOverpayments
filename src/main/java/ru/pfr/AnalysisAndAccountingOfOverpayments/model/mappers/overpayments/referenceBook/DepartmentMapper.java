package ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook;

import org.springframework.stereotype.Component;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.overpayments.referenceBook.DepartmentDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.Department;

@Component
public class DepartmentMapper {

    public DepartmentDto toDto(Department obj) {
        return DepartmentDto.builder()
                .id(obj.getId())
                .name(obj.getName())
                .build();
    }

    public Department fromDto(DepartmentDto dto) {
        return Department.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

}
