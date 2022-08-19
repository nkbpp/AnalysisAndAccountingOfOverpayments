package ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.ros;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
@AllArgsConstructor
@NoArgsConstructor
//@SuperBuilder
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

}
