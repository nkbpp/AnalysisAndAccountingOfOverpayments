package ru.pfr.AnalysisAndAccountingOfOverpayments.service.ros;

import org.springframework.stereotype.Service;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen.Citizen;
import ru.pfr.AnalysisAndAccountingOfOverpayments.repository.ros.CitizenJpaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CitizenService {

    private final CitizenJpaRepository repository;

    public CitizenService(CitizenJpaRepository repository) {
        this.repository = repository;
    }

    public Citizen findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Citizen> findByFIO(String surname, String name, String patronymic){
        return repository
                .findBySurnameLikeIgnoreCaseAndNameLikeIgnoreCaseAndPatronymicLikeIgnoreCase(surname, name, patronymic).orElse(null);
    }

    public List<Citizen> findByFIO(String surname, String name, String patronymic, int pagination, int col){
        return cutTheList(repository
                .findBySurnameLikeIgnoreCaseAndNameLikeIgnoreCaseAndPatronymicLikeIgnoreCase(surname, name, patronymic).orElse(null),
                pagination, col);
    }

    public List<Citizen> findByDistrict(Integer district){
        return repository
                .findByDistrict(district).orElse(null);
    }

    public List<Citizen> findByDistrict(Integer district, int pagination, int col){
        return cutTheList(repository
                .findByDistrict(district).orElse(null), pagination, col);
    }

    public List<Citizen> findBySnils(String snils){
        return repository
                .findBySnils(snils).orElse(null);
    }

    public List<Citizen> findBySnils(String snils, int pagination, int col){
        return cutTheList(repository
                .findBySnils(snils).orElse(null), pagination, col);
    }

    private List<Citizen> cutTheList(List<Citizen> lists, int pagination, int col) {
        List<Citizen> objs = new ArrayList<>();

        int start = col*(pagination-1);
        int end = start + col;

        for (int i = start; i < end && i<lists.size() ; i++) {
            objs.add(lists.get(i));
        }
        return objs;
    }

}
