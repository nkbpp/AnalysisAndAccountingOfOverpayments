package ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class SuperID {

    /*    @GeneratedValue(generator = "UUID")
        @GenericGenerator(
                name = "UUID",
                strategy = "org.hibernate.id.UUIDGenerator"
        )*/
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @NotNull(message = "id cannot be null")
    String id;

    public SuperID() {
    }

    public SuperID(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
