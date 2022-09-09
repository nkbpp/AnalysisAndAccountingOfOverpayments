package ru.pfr.AnalysisAndAccountingOfOverpayments.repository.overpayments.citizen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen.Carer;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen.CitizenRos;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarerJpaRepository extends JpaRepository<Carer, String> {

    Optional<Carer> findById(Long id);

    void deleteById(Long id);

    Optional<List<Carer>> findBySurnameLikeIgnoreCaseAndNameLikeIgnoreCaseAndPatronymicLikeIgnoreCase(String surname, String name, String patronymic);

    /*Optional<List<Carer>> findByDistrict(Integer district);*/

    Optional<List<Carer>> findBySnils(String snils);
}
