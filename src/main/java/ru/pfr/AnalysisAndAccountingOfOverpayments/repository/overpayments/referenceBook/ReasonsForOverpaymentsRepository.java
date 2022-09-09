package ru.pfr.AnalysisAndAccountingOfOverpayments.repository.overpayments.referenceBook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.ReasonsForOverpayments;

import java.util.Optional;

@Repository
public interface ReasonsForOverpaymentsRepository extends JpaRepository<ReasonsForOverpayments, String> {

    Optional<ReasonsForOverpayments> findById(Long id);

    void deleteById(Long id);

}
