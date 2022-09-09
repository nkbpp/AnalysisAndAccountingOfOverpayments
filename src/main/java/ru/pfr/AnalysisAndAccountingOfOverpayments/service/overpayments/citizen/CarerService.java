package ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.citizen;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Carer;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.ReasonsForOverpayments;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen.CitizenRos;
import ru.pfr.AnalysisAndAccountingOfOverpayments.repository.overpayments.citizen.CarerJpaRepository;
import ru.pfr.AnalysisAndAccountingOfOverpayments.repository.ros.CitizenJpaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(transactionManager="overpaymentsTransactionManager")
public class CarerService {

    private final CarerJpaRepository repository;

    public CarerService(CarerJpaRepository repository) {
        this.repository = repository;
    }

    public Carer findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Carer> findByFIO(String surname, String name, String patronymic){
        return repository
                .findBySurnameLikeIgnoreCaseAndNameLikeIgnoreCaseAndPatronymicLikeIgnoreCase(surname, name, patronymic).orElse(null);
    }

    public List<Carer> findByFIO(String surname, String name, String patronymic, int pagination, int col){
        return cutTheList(repository
                .findBySurnameLikeIgnoreCaseAndNameLikeIgnoreCaseAndPatronymicLikeIgnoreCase(surname, name, patronymic).orElse(null),
                pagination, col);
    }

/*    public List<Carer> findByDistrict(Integer district){
        return repository
                .findByDistrict(district).orElse(null);
    }

    public List<Carer> findByDistrict(Integer district, int pagination, int col){
        return cutTheList(repository
                .findByDistrict(district).orElse(null), pagination, col);
    }*/

    public List<Carer> findBySnils(String snils){
        return repository
                .findBySnils(snils).orElse(null);
    }

    public List<Carer> findBySnils(String snils, int pagination, int col){
        return cutTheList(repository
                .findBySnils(snils).orElse(null), pagination, col);
    }

    public void update(Carer carer) {
        repository.save(carer);
    }
    public void save(Carer carer) {
        repository.save(carer);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private List<Carer> cutTheList(List<Carer> lists, int pagination, int col) {
        List<Carer> objs = new ArrayList<>();

        int start = col*(pagination-1);
        int end = start + col;

        for (int i = start; i < end && i<lists.size() ; i++) {
            objs.add(lists.get(i));
        }
        return objs;
    }

}
