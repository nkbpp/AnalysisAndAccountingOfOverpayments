package ru.pfr.AnalysisAndAccountingOfOverpayments.service.overpayments.referenceBook;

import org.springframework.stereotype.Service;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.ReasonsForOverpayments;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.SpecificationOfTheReasonsForOverpayments;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen.Citizen;
import ru.pfr.AnalysisAndAccountingOfOverpayments.repository.overpayments.referenceBook.ReasonsForOverpaymentsRepository;
import ru.pfr.AnalysisAndAccountingOfOverpayments.repository.overpayments.referenceBook.SpecificationOfTheReasonsForOverpaymentsRepository;
import ru.pfr.AnalysisAndAccountingOfOverpayments.repository.ros.CitizenJpaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecificationOfTheReasonsForOverpaymentsService {

    private final SpecificationOfTheReasonsForOverpaymentsRepository repository;

    public SpecificationOfTheReasonsForOverpaymentsService(SpecificationOfTheReasonsForOverpaymentsRepository repository) {
        this.repository = repository;
    }

    public SpecificationOfTheReasonsForOverpayments findById(String id){
        return repository.findById(id).orElse(null);
    }

    public List<SpecificationOfTheReasonsForOverpayments> findAll(){
        return repository.findAll();
    }

    private List<SpecificationOfTheReasonsForOverpayments> cutTheList(List<SpecificationOfTheReasonsForOverpayments> lists, int pagination, int col) {
        List<SpecificationOfTheReasonsForOverpayments> objs = new ArrayList<>();

        int start = col*(pagination-1);
        int end = start + col;

        for (int i = start; i < end && i<lists.size() ; i++) {
            objs.add(lists.get(i));
        }
        return objs;

    }

}
