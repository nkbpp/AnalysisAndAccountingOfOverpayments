package ru.pfr.AnalysisAndAccountingOfOverpayments.service.ros;

import org.springframework.stereotype.Service;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen.Citizen;
import ru.pfr.AnalysisAndAccountingOfOverpayments.repository.ros.CitizenJpaRepository;

import java.util.List;

@Service
public class CitizenService {

    private final CitizenJpaRepository repository;

    public CitizenService(CitizenJpaRepository repository) {
        this.repository = repository;
    }

    public Citizen findById(String id){
        return repository.findById(id).orElse(null);
    }

    public List<Citizen> findByFIO(String surname, String name, String patronymic){
        return repository
                .findBySurnameLikeIgnoreCaseAndNameLikeIgnoreCaseAndPatronymicLikeIgnoreCase(surname, name, patronymic).orElse(null);
    }

    public List<Citizen> findByDistrict(Integer district){
        return repository
                .findByDistrict(district).orElse(null);
    }

    public List<Citizen> findBySnils(String snils){
        return repository
                .findBySnils(snils).orElse(null);
    }

}
