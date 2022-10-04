package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.findCitizen;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.fio.FIODto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.snils.SNILSDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.mappers.overpayments.referenceBook.DistrictMapper;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook.DistrictService;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = { "/aaaop"})
public class FindCitizenController {

    private final DistrictService districtService;

    private final DistrictMapper districtMapper;

    @GetMapping(value = { "/vievFindCitizenBySnils"})
    public String vievFindCitizenBySnils(
            Model model
    ){
        model.addAttribute("find", "snils");
        model.addAttribute("snilsdto", new SNILSDto());
        return "viev/findCitizen/findCitizen";
    }

    @GetMapping(value = { "/vievFindCitizenByFio"})
    public String vievFindCitizenByFio(
            Model model
    ){
        model.addAttribute("find", "fio");
        model.addAttribute("fiodto", new FIODto());
        return "viev/findCitizen/findCitizen";
    }

    @GetMapping(value = { "/vievFindCitizenByDistrict"})
    public String vievFindCitizenByDistrict(
            Model model
    ){
        model.addAttribute("find", "district");
        model.addAttribute("district", districtService.findAll().stream().map(
                district -> districtMapper.toDto(district)
        ).collect(Collectors.toList()));
        /*model.addAttribute("districtdto", new DistrictDto(0));*/
        return "viev/findCitizen/findCitizen";
    }

}
