package ru.pfr.AnalysisAndAccountingOfOverpayments.service.ros;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen.CitizenRos;
import ru.pfr.AnalysisAndAccountingOfOverpayments.repository.ros.CitizenJpaRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CitizenService {

    private final CitizenJpaRepository repository;

    public CitizenService(CitizenJpaRepository repository) {
        this.repository = repository;
    }

    public CitizenRos findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<CitizenRos> findByFIO(String surname, String name, String patronymic){
        return repository
                .findBySurnameLikeIgnoreCaseAndNameLikeIgnoreCaseAndPatronymicLikeIgnoreCase(surname, name, patronymic).orElse(null);
    }

    public List<CitizenRos> findByFIO(String surname, String name, String patronymic, int pagination, int col){
        return cutTheList(repository
                .findBySurnameLikeIgnoreCaseAndNameLikeIgnoreCaseAndPatronymicLikeIgnoreCase(surname, name, patronymic).orElse(null),
                pagination, col);
    }

    public List<CitizenRos> findByFioAndDate(String surname, String name, String patronymic, LocalDate rdat, int pagination, int col){
        return cutTheList(repository
                        .findByFioAndDate(surname, name, patronymic, rdat).orElse(null),
                pagination, col);
    }


    public List<CitizenRos> findByDistrict(Integer district){
        return repository
                .findByDistrictOrderByRdatDesc(district).orElse(null);
    }

    public List<CitizenRos> findByDistrict(Integer district, int pagination, int col){
        return cutTheList(repository
                .findByDistrictOrderByRdatDesc(district).orElse(null), pagination, col);
    }

    public List<CitizenRos> findBySnils(String snils){
        return repository
                .findBySnils(snils).orElse(null);
    }

    public List<CitizenRos> findBySnils(String snils, int pagination, int col){
        return cutTheList(repository
                .findBySnils(snils).orElse(null), pagination, col);
    }

    private List<CitizenRos> cutTheList(List<CitizenRos> lists, int pagination, int col) {
        List<CitizenRos> objs = new ArrayList<>();

        int start = col*(pagination-1);
        int end = start + col;

        for (int i = start; i < end && i<lists.size() ; i++) {
            objs.add(lists.get(i));
        }
        return objs;
    }

}
