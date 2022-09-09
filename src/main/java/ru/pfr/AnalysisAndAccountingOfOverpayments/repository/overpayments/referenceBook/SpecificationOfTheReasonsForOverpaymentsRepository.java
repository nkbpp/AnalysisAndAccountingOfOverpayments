package ru.pfr.AnalysisAndAccountingOfOverpayments.repository.overpayments.referenceBook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.SpecificationOfTheReasonsForOverpayments;

import java.util.Optional;

@Repository
public interface SpecificationOfTheReasonsForOverpaymentsRepository extends JpaRepository<SpecificationOfTheReasonsForOverpayments, String> {

    Optional<SpecificationOfTheReasonsForOverpayments> findById(Long id);
    void deleteById(Long id);
}
