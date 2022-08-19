package ru.pfr.AnalysisAndAccountingOfOverpayments.repository.ros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen.Citizen;

import java.util.List;
import java.util.Optional;

@Repository
public interface CitizenJpaRepository extends JpaRepository<Citizen, String> {

    Optional<Citizen> findById(Long id);

    List<Citizen> findAll();

    Optional<List<Citizen>> findBySurnameLikeIgnoreCaseAndNameLikeIgnoreCaseAndPatronymicLikeIgnoreCase(String surname, String name, String patronymic);

    Optional<List<Citizen>> findByDistrict(Integer district);

    Optional<List<Citizen>> findBySnils(String snils);

}
