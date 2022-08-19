package ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "reasonsForOverpayments")
public class ReasonsForOverpayments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "reasonsForOverpayments")
    private String reasonsForOverpayments;

}
