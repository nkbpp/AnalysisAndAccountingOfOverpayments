package ru.pfr.AnalysisAndAccountingOfOverpayments.patternRepository.ros.citizen;

import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen.Citizen;
import ru.pfr.AnalysisAndAccountingOfOverpayments.patternRepository.ros.RosRepository;
import ru.pfr.AnalysisAndAccountingOfOverpayments.patternRepository.ros.Specification;
import ru.pfr.AnalysisAndAccountingOfOverpayments.repository.ros.CitizenJpaRepository;

import java.util.List;

public class CitizenRosRepository implements RosRepository<Citizen> {

    private final CitizenJpaRepository citizenJpaRepository;

    public CitizenRosRepository(CitizenJpaRepository citizenJpaRepository) {
        this.citizenJpaRepository = citizenJpaRepository;
    }

    @Override
    public List query(Specification<Citizen> s) {
        return null;
    }


}
