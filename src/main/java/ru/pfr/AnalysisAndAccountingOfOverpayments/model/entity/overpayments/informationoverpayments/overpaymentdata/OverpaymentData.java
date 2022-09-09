package ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.informationoverpayments.overpaymentdata;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.ReasonsForOverpayments;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.entity.overpayments.referenceBook.SpecificationOfTheReasonsForOverpayments;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class OverpaymentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String documentNumber; //номер документа

    //Причина переплаты
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private ReasonsForOverpayments reasonsForOverpayments;

    //Конкретизация причины переплаты (при нажатии всплывающее окно с возможностью выбора) выбор из списка
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private  SpecificationOfTheReasonsForOverpayments specificationOfTheReasonsForOverpayments;

    private String paymentType; //Вид выплаты todo

    private LocalDate dateOfDetectionOfOverpayment;//Дата выявления переплаты
    private LocalDate overpaymentPeriodFrom;//Период переплаты
    private LocalDate overpaymentPeriodFor;//Период переплаты
    private Double overpaymentAmount;//Сумма переплаты
    private Boolean isApplicationForVoluntaryRedemption;//Заявление о добровольном погашении – да/нет
    private LocalDate dateOfDeathOfPensioner;//Дата смерти пенсионера
    private Boolean redemptionOrHolding; //Погашение/удержание true - Погашение


    private Integer currentYear; //текущий год
    private Integer currentPaymentMonth; //текущий выплатной месяц
    private Double repaymentAmount; //Сумма погашения
    private Double retentionPercentage; //процент удержания
    private Double retentionAmount; //сумма удержания
    private Double fixedAmountOfDeduction; //твердая сумма удержания

    private String structuralSubdivision; //Структурное подразделение todo
    private String comment; //ввод дополнительной информации при необходимости


}
