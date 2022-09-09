package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.findCitizen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.district.DistrictDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.fio.FIODto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.snils.SNILSDto;

@Controller
@RequestMapping(value = { "/aaaop"})
public class FindCitizenController {

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
        /*model.addAttribute("districtdto", new DistrictDto(0));*/
        return "viev/findCitizen/findCitizen";
    }

}
