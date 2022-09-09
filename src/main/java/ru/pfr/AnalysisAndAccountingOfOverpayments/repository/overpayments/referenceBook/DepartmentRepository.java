package ru.pfr.AnalysisAndAccountingOfOverpayments.repository.overpayments.referenceBook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.Department;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    Optional<Department> findById(Long id);

    void deleteById(Long id);

}
