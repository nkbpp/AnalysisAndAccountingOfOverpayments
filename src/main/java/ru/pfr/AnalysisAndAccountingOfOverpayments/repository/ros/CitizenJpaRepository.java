package ru.pfr.AnalysisAndAccountingOfOverpayments.repository.ros;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen.CitizenRos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CitizenJpaRepository extends JpaRepository<CitizenRos, String> {

    Optional<CitizenRos> findById(Long id);

    List<CitizenRos> findAll();

    Optional<List<CitizenRos>> findBySurnameLikeIgnoreCaseAndNameLikeIgnoreCaseAndPatronymicLikeIgnoreCase(String surname, String name, String patronymic);
    @Query(
            value = "SELECT * FROM PF.MAN " +
                    "WHERE (?1 is null or FA like ?1%) and " +
                    "(?2 is null or IM like ?2%) and " +
                    "(?3 is null or OT like ?3%) and " +
                    "(?4 is null or RDAT = ?4) order by RDAT desc ",
            nativeQuery = true)
    Optional<List<CitizenRos>> findByFioAndDate(String surname, String name, String patronymic, LocalDate date);

    @Query(
            value = "SELECT * FROM PF.MAN " +
                    "WHERE id in(" +
                    "SELECT ID_IJD FROM PF.IJD WHERE id IN(" +
                    "SELECT ID FROM PF.MAN WHERE NPERS = ?1" +
                    "))",
            nativeQuery = true)
    Optional<List<CitizenRos>> findIjdBySnils(String snils);

    @Query(
            value = "SELECT * " +
                    "FROM PF.MAN WHERE id in(" +
                    "SELECT ID_UHOD  " +
                    "FROM PF.PE WHERE id IN(SELECT ID FROM PF.MAN WHERE NPERS = ?1) AND SROKS = (SELECT MAX(SROKS) FROM PF.PE WHERE id IN(SELECT ID FROM PF.MAN WHERE NPERS = ?1))" +
                    ")",
            nativeQuery = true)
    Optional<List<CitizenRos>> findPEBySnils(String snils);

    Optional<List<CitizenRos>> findByDistrictOrderByRdatDesc(Integer district);

    Optional<List<CitizenRos>> findBySnils(String snils);

}
