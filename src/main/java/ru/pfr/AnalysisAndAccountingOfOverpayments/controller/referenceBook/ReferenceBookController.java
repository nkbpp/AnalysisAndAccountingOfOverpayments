package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.referenceBook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.snils.SNILSDto;

@Controller
@RequestMapping(value = { "/aaaop/referenceBook"})
public class ReferenceBookController {

    @GetMapping(value = { "/vievReferenceBookReasonsForOverpayments"})
    public String vievReferenceBookReasonsForOverpayments(
            Model model
    ){
        return "viev/referenceBook/vievReferenceBookReasonsForOverpayments";
    }
}
