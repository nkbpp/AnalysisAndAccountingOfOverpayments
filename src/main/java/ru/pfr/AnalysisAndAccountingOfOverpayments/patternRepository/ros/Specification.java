package ru.pfr.AnalysisAndAccountingOfOverpayments.patternRepository.ros;

public interface Specification<T> {
    boolean specified(T t);
}
