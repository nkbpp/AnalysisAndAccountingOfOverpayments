package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.statistics;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook.DistrictMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook.ReasonsForOverpaymentsMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook.SpecificationOfTheReasonsForOverpaymentsMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook.DistrictService;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook.ReasonsForOverpaymentsService;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook.SpecificationOfTheReasonsForOverpaymentsService;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = { "/aaaop/statistics"})
public class StatisticsController {

    private final ReasonsForOverpaymentsService reasonsForOverpaymentsService;
    private final ReasonsForOverpaymentsMapper reasonsForOverpaymentsMapper;

    private final SpecificationOfTheReasonsForOverpaymentsService specificationOfTheReasonsForOverpaymentsService;

    private final SpecificationOfTheReasonsForOverpaymentsMapper specificationOfTheReasonsForOverpaymentsMapper;

    private final DistrictService districtService;

    private final DistrictMapper districtMapper;


    @GetMapping()
    public String vievStatistics(
            Model model
    ){
        model.addAttribute("selectReasonsForOverpayments", reasonsForOverpaymentsService.findAll().stream().map(
                reasonsForOverpayments -> reasonsForOverpaymentsMapper.toDto(reasonsForOverpayments)
        ).collect(Collectors.toList()));
        model.addAttribute("selectSpecificationOfTheReasonsForOverpayments", specificationOfTheReasonsForOverpaymentsService.findAll().stream().map(
                specificationOfTheReasonsForOverpayments -> specificationOfTheReasonsForOverpaymentsMapper.toDto(specificationOfTheReasonsForOverpayments)
        ).collect(Collectors.toList()));
        model.addAttribute("district", districtService.findAll().stream().map(
                district -> districtMapper.toDto(district)
        ).collect(Collectors.toList()));
        return "viev/statistics/statistics";
    }

/*    @GetMapping(value = { "/vievReferenceBookReasonsForOverpayments"})
    public String vievReferenceBookReasonsForOverpayments(
            Model model
    ){
        return "viev/referenceBook/vievReferenceBookReasonsForOverpayments";
    }*/
}
