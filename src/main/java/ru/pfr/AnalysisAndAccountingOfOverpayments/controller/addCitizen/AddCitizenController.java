package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.addCitizen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = { "/aaaop"})
public class AddCitizenController {

    @GetMapping(value = { "/menuAddCitizen"})
    public String vievAddCitizen(
            //Model model
    ){
        return "viev/addCitizen/addCitizen";
    }

}
