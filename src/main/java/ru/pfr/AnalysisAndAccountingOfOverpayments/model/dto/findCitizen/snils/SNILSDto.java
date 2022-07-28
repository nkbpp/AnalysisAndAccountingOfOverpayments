package ru.pfr.AnalysisAndAccountingOfOverpayments.model.dto.findCitizen.snils;

import ru.pfr.AnalysisAndAccountingOfOverpayments.model.annotations.snils.CheckSNILS;

public class SNILSDto {

    @CheckSNILS
    private String snils;

    public SNILSDto() {
    }

    public SNILSDto(String snils) {
        this.snils = snils;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }
}
