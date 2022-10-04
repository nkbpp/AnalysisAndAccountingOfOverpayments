package ru.pfr.AnalysisAndAccountingOfOverpayments.repository.overpayments.citizen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Dependent;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Pensioner;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.District;

import java.util.List;
import java.util.Optional;

@Repository
public interface PensionerJpaRepository extends JpaRepository<Pensioner, String> {

    Optional<Pensioner> findById(Long id);
    Optional<List<Pensioner>> findByDistrict(District district);

    void deleteById(Long id);

    Optional<List<Pensioner>> findBySurnameLikeIgnoreCaseAndNameLikeIgnoreCaseAndPatronymicLikeIgnoreCase(String surname, String name, String patronymic);

   /* Optional<List<Pensioner>> findByDistrict(Integer district);*/

    Optional<List<Pensioner>> findBySnils(String snils);
}
