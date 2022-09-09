package ru.pfr.AnalysisAndAccountingOfOverpayments.repository.overpayments.citizen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Carer;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Dependent;

import java.util.List;
import java.util.Optional;

@Repository
public interface DependentJpaRepository extends JpaRepository<Dependent, String> {

    Optional<Dependent> findById(Long id);

    void deleteById(Long id);

    Optional<List<Dependent>> findBySurnameLikeIgnoreCaseAndNameLikeIgnoreCaseAndPatronymicLikeIgnoreCase(String surname, String name, String patronymic);

    /*Optional<List<Dependent>> findByDistrict(Integer district);*/

    Optional<List<Dependent>> findBySnils(String snils);

}
