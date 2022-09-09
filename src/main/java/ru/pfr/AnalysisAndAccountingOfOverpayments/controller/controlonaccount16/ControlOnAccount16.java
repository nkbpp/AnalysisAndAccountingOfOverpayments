package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.controlonaccount16;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook.DepartmentMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook.DepartmentService;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = { "/aaaop"})
public class ControlOnAccount16 {

    private final DepartmentService departmentService;

    private final DepartmentMapper departmentMapper;

    @GetMapping(value = { "/vievControlOnAccount16"})
    public String vievControlOnAccount16(
            Model model
    ){
        model.addAttribute("department", departmentService.findAll().stream().map(
                department -> departmentMapper.toDto(department)
        ).collect(Collectors.toList()));
        return "viev/controlOnAccount16/vievControlOnAccount16";
    }

}
