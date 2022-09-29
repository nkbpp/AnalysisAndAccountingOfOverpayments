package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.addCitizen;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook.DistrictMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook.DistrictService;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = { "/aaaop"})
public class AddCitizenController2 {

    private final DistrictService districtService;

    private final DistrictMapper districtMapper;

    @GetMapping(value = { "/menuAddCitizen2"})
    public String vievAddCitizen(
            Model model
    ){
        model.addAttribute("district", districtService.findAll().stream().map(
                district -> districtMapper.toDto(district)
        ).collect(Collectors.toList()));
        return "viev/addCitizen/addCitizen2";
    }

}
