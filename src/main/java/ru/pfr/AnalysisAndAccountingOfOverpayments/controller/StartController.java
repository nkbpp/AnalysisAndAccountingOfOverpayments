package ru.pfr.AnalysisAndAccountingOfOverpayments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = { "/aaaop/index"})
public class StartController {
    @GetMapping
    public String vievTable(
            //@AuthenticationPrincipal User user,
            Model model
    ){
        return "index";
    }





}
