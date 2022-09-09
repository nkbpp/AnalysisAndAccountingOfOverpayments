package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.informationoverpayments;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook.DepartmentMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook.DistrictMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook.ReasonsForOverpaymentsMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook.SpecificationOfTheReasonsForOverpaymentsMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook.DepartmentService;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook.DistrictService;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook.ReasonsForOverpaymentsService;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook.SpecificationOfTheReasonsForOverpaymentsService;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = { "/aaaop/"})
public class InformationOverpaymentController {

    private final ReasonsForOverpaymentsService reasonsForOverpaymentsService;
    private final ReasonsForOverpaymentsMapper reasonsForOverpaymentsMapper;

    private final SpecificationOfTheReasonsForOverpaymentsService specificationOfTheReasonsForOverpaymentsService;

    private final SpecificationOfTheReasonsForOverpaymentsMapper specificationOfTheReasonsForOverpaymentsMapper;

    private final DepartmentService departmentService;

    private final DepartmentMapper departmentMapper;

    @GetMapping(value = { "/vievInformationOverpayments"})
    public String vievAddCitizen(
            Model model
    ){
        model.addAttribute("selectReasonsForOverpayments", reasonsForOverpaymentsService.findAll().stream().map(
                reasonsForOverpayments -> reasonsForOverpaymentsMapper.toDto(reasonsForOverpayments)
        ).collect(Collectors.toList()));
        model.addAttribute("selectSpecificationOfTheReasonsForOverpayments", specificationOfTheReasonsForOverpaymentsService.findAll().stream().map(
                specificationOfTheReasonsForOverpayments -> specificationOfTheReasonsForOverpaymentsMapper.toDto(specificationOfTheReasonsForOverpayments)
        ).collect(Collectors.toList()));
        model.addAttribute("department", departmentService.findAll().stream().map(
                department -> departmentMapper.toDto(department)
        ).collect(Collectors.toList()));
        //return "viev/addCitizen/addCitizen";
        return "viev/informationoverpayments/overpaymentdata/overpaymentData";
    }

}
