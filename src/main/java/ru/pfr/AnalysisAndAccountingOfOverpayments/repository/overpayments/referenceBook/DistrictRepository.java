package ru.pfr.AnalysisAndAccountingOfOverpayments.repository.overpayments.referenceBook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.District;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.ReasonsForOverpayments;

import java.util.Optional;

@Repository
public interface DistrictRepository extends JpaRepository<District, String> {

    Optional<District> findById(Long id);
    Optional<District> findByKod(Integer id);

    void deleteById(Long id);

}
