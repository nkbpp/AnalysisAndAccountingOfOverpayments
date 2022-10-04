package ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.citizen;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.District;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
public class Pensioner extends Citizen {

    @OneToMany(mappedBy = "pensioner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carer> carers = new ArrayList<>();

    @OneToMany(mappedBy = "pensioner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dependent> dependents = new ArrayList<>();

    @Builder
    public Pensioner(Long id, String snils, String surname, String name, String patronymic, String adrreg, String tel, District district, List<Carer> carers, List<Dependent> dependents) {
        super(id, snils, surname, name, patronymic, adrreg, tel, district);
        this.carers = carers;
        this.dependents = dependents;
    }

    public Pensioner(String snils, String surname, String name, String patronymic, String adrreg, String tel, District district, List<Carer> carers, List<Dependent> dependents) {
        super(snils, surname, name, patronymic, adrreg, tel, district);
        this.carers = carers;
        this.dependents = dependents;
    }

    public Pensioner(String snils, String surname, String name, String patronymic, String adrreg, String tel, District district) {
        super(snils, surname, name, patronymic, adrreg, tel, district);
    }

    public void addCarer(Carer carer) {
        this.carers.add(carer);
        carer.setPensioner(this);
    }

    public void setAllCarer(List<Carer> carers) {
        for (Carer c :
                carers) {
            addCarer(c);
        }
    }

    public void removeCarer(Carer carer) {
        this.carers.remove(carer);
        carer.setPensioner(null);
    }

    public void addDependent(Dependent dependent) {
        this.dependents.add(dependent);
        dependent.setPensioner(this);
    }

    public void setAllDependent(List<Dependent> dependents) {
        for (Dependent d :
                dependents) {
            addDependent(d);
        }
    }

    public void removeDependent(Dependent dependent) {
        this.dependents.remove(dependent);
        dependent.setPensioner(null);
    }

}
