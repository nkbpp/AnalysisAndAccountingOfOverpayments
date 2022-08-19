package ru.pfr.AnalysisAndAccountingOfOverpayments.controller.controlonaccount16;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = { "/aaaop"})
public class ControlOnAccount16 {

    @GetMapping(value = { "/vievControlOnAccount16"})
    public String vievControlOnAccount16(
    ){
        return "viev/controlOnAccount16/vievControlOnAccount16";
    }

}
