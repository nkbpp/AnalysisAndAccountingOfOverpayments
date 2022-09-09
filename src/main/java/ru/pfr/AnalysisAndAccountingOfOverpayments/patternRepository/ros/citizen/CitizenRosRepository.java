package ru.pfr.AnalysisAndAccountingOfOverpayments.patternRepository.ros.citizen;

import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen.CitizenRos;
import ru.pfr.AnalysisAndAccountingOfOverpayments.patternRepository.ros.RosRepository;
import ru.pfr.AnalysisAndAccountingOfOverpayments.patternRepository.ros.Specification;
import ru.pfr.AnalysisAndAccountingOfOverpayments.repository.ros.CitizenJpaRepository;

import java.util.List;

public class CitizenRosRepository implements RosRepository<CitizenRos> {

    private final CitizenJpaRepository citizenJpaRepository;

    public CitizenRosRepository(CitizenJpaRepository citizenJpaRepository) {
        this.citizenJpaRepository = citizenJpaRepository;
    }

    @Override
    public List query(Specification<CitizenRos> s) {
        return null;
    }


}
