package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.referenceBook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = { "/aaaop/referenceBook"})
public class SpecificationOfTheReasonsForOverpaymentsController {

    @GetMapping(value = { "/vievReferenceBookSpecificationOfTheReasonsForOverpayments"})
    public String vievReferenceBookReasonsForOverpayments(
            Model model
    ){
        return "viev/referenceBook/vievReferenceBookSpecificationOfTheReasonsForOverpayments";
    }
}
