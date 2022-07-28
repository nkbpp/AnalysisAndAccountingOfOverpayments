package ru.pfr.AnalysisAndAccountingOfOverpayments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.district.DistrictDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.fio.FIODto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.snils.SNILSDto;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen.Citizen;
import ru.pfr.AnalysisAndAccountingOfOverpayments.service.ros.CitizenService;

import java.util.List;

@Controller
@RequestMapping(value = { "/aaaop/index"})
public class StartController {

    private final CitizenService citizenService;

    public StartController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }


    @GetMapping
    public String vievTable(
            //@AuthenticationPrincipal User user,
            Model model
    ){
        Citizen citizen = citizenService
                .findById("041004013247600001406893705253");
        List<Citizen> citizen2 = citizenService
                .findByFIO("ПЫХАНОВА", "АННА", "ГРИГОРЬЕВНА");
        List<Citizen> citizen3 = citizenService
                .findByDistrict(0);
        /*        Citizen citizen4 = rosRepository
                .findByUuidLike("041004013247600001406893705253")
                .orElse(new Citizen("1","sdf","sdf","sdf"));

        Citizen citizen1 = rosRepository
                .findByUuid2("041004013247600001406893705253")
                .orElse(new Citizen("1","sdf","sdf","sdf"));
        Citizen citizen = rosRepository
                .findTest()
                .orElse(new Citizen("1","sdf","sdf","sdf"));*/
/*        UUID j = UUID.randomUUID();
        Citizen citizen = rosRepository
                .findByUuid(UUID.fromString("041004013247600001406893705253"))
                .orElse(new Citizen(UUID.randomUUID(),"sdf","sdf","sdf"));*/
        //Citizen citizen = rosRepository.getReferenceById(UUID.fromString("041004013247600001406893705253"));
        return "index";
    }


    @GetMapping(value = { "/vievFindCitizenBySnils"})
    public String vievFindCitizenBySnils(
            Model model
    ){
        model.addAttribute("find", "snils");
        return "fragment/findCitizen/findCitizen";
    }

    @GetMapping(value = { "/vievFindCitizenByFio"})
    public String vievFindCitizenByFio(
            Model model
    ){
        model.addAttribute("find", "fio");
        return "fragment/findCitizen/findCitizen";
    }

    @GetMapping(value = { "/vievFindCitizenByDistrict"})
    public String vievFindCitizenByDistrict(
            Model model
    ){
        model.addAttribute("find", "district");
        return "fragment/findCitizen/findCitizen";
    }


    @RequestMapping(value="/findCitizen", method= RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute SNILSDto snils, Model model) {
        List<Citizen> citizen = citizenService
                .findBySnils(snils.getSnils());
        //model.addAttribute("greeting", greeting);
        return "index";
    }

    @RequestMapping(value="/findCitizen", method= RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute FIODto fio, Model model) {
        List<Citizen> citizen = citizenService
                .findByFIO(fio.getSurname(), fio.getName(), fio.getPatronymic());
        //model.addAttribute("greeting", greeting);
        return "index";
    }

    @RequestMapping(value="/findCitizen", method= RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute DistrictDto district, Model model) {
        List<Citizen> citizen = citizenService
                .findByDistrict(district.getNumDistrict());
        //model.addAttribute("greeting", greeting);
        return "index";
    }

}
