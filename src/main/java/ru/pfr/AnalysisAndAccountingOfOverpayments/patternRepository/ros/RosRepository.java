package ru.pfr.AnalysisAndAccountingOfOverpayments.patternRepository.ros;

import java.util.List;

public interface RosRepository<T> {
    List query(Specification<T> s);
}
