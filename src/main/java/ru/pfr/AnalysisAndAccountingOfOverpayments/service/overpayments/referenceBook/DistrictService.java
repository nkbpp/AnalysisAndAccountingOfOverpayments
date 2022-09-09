package ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.District;
import ru.pfr.AnalysisAndAccountingOfOverpayments.repository.overpayments.referenceBook.DistrictRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(transactionManager="overpaymentsTransactionManager")
public class DistrictService {

    private final DistrictRepository repository;

    public District findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<District> findAll(){
        return repository.findAll();
    }

    public List<District> findAll(int pagination, int col){
        return cutTheList(repository.findAll(), pagination, col);
    }

    public void update(District district) {
        repository.save(district);
    }
    public void save(District district) {
        repository.save(district);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private List<District> cutTheList(List<District> lists, int pagination, int col) {
        List<District> objs = new ArrayList<>();

        int start = col*(pagination-1);
        int end = start + col;

        for (int i = start; i < end && i<lists.size() ; i++) {
            objs.add(lists.get(i));
        }
        return objs;
    }

}
