package ru.pfr.AnalysisAndAccountingOfOverpayments.repository.ros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen.Citizen;

import java.util.List;
import java.util.Optional;

@Repository
public interface CitizenJpaRepository extends JpaRepository<Citizen, String> {

    public Optional<Citizen> findById(String id);
    public Optional<List<Citizen>> findBySurnameLikeIgnoreCaseAndNameLikeIgnoreCaseAndPatronymicLikeIgnoreCase(String surname, String name, String patronymic);

    public Optional<List<Citizen>> findByDistrict(Integer district);

    public Optional<List<Citizen>> findBySnils(String snils);

    /*public Optional<Citizen> findByUuidLike(String uuid);

    @Query(
            value = "SELECT ID, RA, FA, IM, OT, RDAT, ADRFAKT, ADRREG, TEL FROM PF.MAN WHERE id = ?1",
            nativeQuery = true)
    public Optional<Citizen> findByUuid2(String uuid);

    @Query(
            value = "SELECT ID, RA, FA, IM, OT, RDAT, ADRFAKT, ADRREG, TEL FROM PF.MAN WHERE id = '041004013247600001406893705253'",
            nativeQuery = true)
    public Optional<Citizen> findTest();*/

}
