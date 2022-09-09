package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.referenceBook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = { "/aaaop/referenceBook"})
public class DepartmentController {

    @GetMapping(value = { "/vievDepartment"})
    public String vievReferenceBookReasonsForOverpayments(
    ){
        return "viev/referenceBook/vievDepartment";
    }

}
