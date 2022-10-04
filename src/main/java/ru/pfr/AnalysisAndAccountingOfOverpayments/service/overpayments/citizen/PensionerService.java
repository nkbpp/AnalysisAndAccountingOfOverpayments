package ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.citizen;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Carer;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Dependent;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Pensioner;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.District;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.ReasonsForOverpayments;
import ru.pfr.AnalysisAndAccountingOfOverpayments.repository.overpayments.citizen.PensionerJpaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(transactionManager="overpaymentsTransactionManager")
public class PensionerService {

    private final PensionerJpaRepository repository;

    public PensionerService(PensionerJpaRepository repository) {
        this.repository = repository;
    }

    public Pensioner findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Pensioner> findByFIO(String surname, String name, String patronymic){
        return repository
                .findBySurnameLikeIgnoreCaseAndNameLikeIgnoreCaseAndPatronymicLikeIgnoreCase(surname, name, patronymic).orElse(null);
    }

    public List<Pensioner> findByFIO(String surname, String name, String patronymic, int pagination, int col){
        return cutTheList(repository
                        .findBySurnameLikeIgnoreCaseAndNameLikeIgnoreCaseAndPatronymicLikeIgnoreCase(surname, name, patronymic).orElse(null),
                pagination, col);
    }

    public List<Pensioner> findByDistrict(District district){
        return repository.findByDistrict(district).orElse(null);
    }

    public List<Pensioner> findByDistrict(District district, int pagination, int col){
        return cutTheList(repository
                .findByDistrict(district).orElse(null), pagination, col);
    }

    public List<Pensioner> findBySnils(String snils){
        return repository
                .findBySnils(snils).orElse(null);
    }

    public List<Pensioner> findBySnils(String snils, int pagination, int col){
        return cutTheList(repository
                .findBySnils(snils).orElse(null), pagination, col);
    }

    public List<Pensioner> findAll(){
        return repository.findAll();
    }

    public List<Pensioner> findAll(int pagination, int col){
        return cutTheList(repository.findAll(), pagination, col);
    }

    public void update(Pensioner pensioner) {
        repository.save(pensioner);
    }

    public void save(Pensioner pensioner) {
        for (Carer carer : pensioner.getCarers()) { //добавляем ссылку на контракт в Carer
            carer.setPensioner(pensioner);
        }
        for (Dependent dependent : pensioner.getDependents()) { //добавляем ссылку на контракт в Dependent
            dependent.setPensioner(pensioner);
        }
        repository.save(pensioner);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private List<Pensioner> cutTheList(List<Pensioner> lists, int pagination, int col) {
        List<Pensioner> objs = new ArrayList<>();

        int start = col*(pagination-1);
        int end = start + col;

        for (int i = start; i < end && i<lists.size() ; i++) {
            objs.add(lists.get(i));
        }
        return objs;
    }

}
