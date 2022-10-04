package ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.District;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Data
@NoArgsConstructor
@Entity
//@Table(name = "MAN", schema = "PF")
public class Carer extends Citizen {

    public Carer(String snils, String surname, String name, String patronymic, String adrreg, String tel, District district) {
        super(snils, surname, name, patronymic, adrreg, tel, district);
    }

    @Builder
    public Carer(Long id, String snils, String surname, String name, String patronymic, String adrreg, String tel, District district) {
        super(id, snils, surname, name, patronymic, adrreg, tel, district);
    }
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pensioner_id")
    private Pensioner pensioner;

    @JsonIgnore
    public Pensioner getPensioner() {
        return pensioner;
    }

}
