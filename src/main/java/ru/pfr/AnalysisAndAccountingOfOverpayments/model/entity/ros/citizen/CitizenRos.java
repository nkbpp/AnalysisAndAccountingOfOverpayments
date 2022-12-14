package ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.citizen;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.annotations.district.District;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.annotations.fio.CustomDateDeserializerRuAndEn;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros.SuperIDFIO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
//@SuperBuilder
@Entity
@Table(name = "MAN", schema = "PF")
public class CitizenRos extends SuperIDFIO {

    @Column(name = "RDAT")
    @JsonDeserialize(using = CustomDateDeserializerRuAndEn.class)
    private LocalDate rdat;

    @Column(name = "ADRFAKT")
    private String adrfakt;

    @Column(name = "ADRREG")
    private String adrreg;

    @Column(name = "TEL")
    private String tel;

    @Column(name = "RA")
    @District
    private Integer district;

    @Column(name = "NPERS")
    private String snils;

    @Column(name = "PW")
    private String pw;


    @Builder
    public CitizenRos(String id,
                      String surname, String name, String patronymic,
                      LocalDate rdat, String adrfakt, String adrreg, String tel, Integer district, String snils) {
        super(id, surname, name, patronymic);
        this.rdat = rdat;
        this.adrfakt = adrfakt;
        this.adrreg = adrreg;
        this.tel = tel;
        this.district = district;
        this.snils = snils;
    }
}
