package ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.citizen;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Dependent;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.ReasonsForOverpayments;
import ru.pfr.AnalysisAndAccountingOfOverpayments.repository.overpayments.citizen.DependentJpaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(transactionManager="overpaymentsTransactionManager")
public class DependentService {

    private final DependentJpaRepository repository;

    public DependentService(DependentJpaRepository repository) {
        this.repository = repository;
    }

    public Dependent findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Dependent> findByFIO(String surname, String name, String patronymic){
        return repository
                .findBySurnameLikeIgnoreCaseAndNameLikeIgnoreCaseAndPatronymicLikeIgnoreCase(surname, name, patronymic).orElse(null);
    }

    public List<Dependent> findByFIO(String surname, String name, String patronymic, int pagination, int col){
        return cutTheList(repository
                        .findBySurnameLikeIgnoreCaseAndNameLikeIgnoreCaseAndPatronymicLikeIgnoreCase(surname, name, patronymic).orElse(null),
                pagination, col);
    }

/*    public List<Dependent> findByDistrict(Integer district){
        return repository
                .findByDistrict(district).orElse(null);
    }

    public List<Dependent> findByDistrict(Integer district, int pagination, int col){
        return cutTheList(repository
                .findByDistrict(district).orElse(null), pagination, col);
    }*/

    public List<Dependent> findBySnils(String snils){
        return repository
                .findBySnils(snils).orElse(null);
    }

    public List<Dependent> findBySnils(String snils, int pagination, int col){
        return cutTheList(repository
                .findBySnils(snils).orElse(null), pagination, col);
    }

    public void update(Dependent dependent) {
        repository.save(dependent);
    }
    public void save(Dependent dependent) {
        repository.save(dependent);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private List<Dependent> cutTheList(List<Dependent> lists, int pagination, int col) {
        List<Dependent> objs = new ArrayList<>();

        int start = col*(pagination-1);
        int end = start + col;

        for (int i = start; i < end && i<lists.size() ; i++) {
            objs.add(lists.get(i));
        }
        return objs;
    }

}
