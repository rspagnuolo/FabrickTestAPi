package com.fabrick.webapp.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "TRANSACTION")
public class TransactionEntity  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="UID")
    private String uid;

    @Column(name="OPERATION_ID")
    private String operationId;

    @Basic
    @Column(name="TRANSACTION_ID")
    private String transactionId;

    @Column(name="PAYLOAD_UID")
    private String payloadUid;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "PAYLOAD_UID",nullable = false,insertable=false, updatable=false)
    private PayloadEntity payloadEntity;

    @Basic
    @Column(name="ACCOUNT_DATE")
    private String accountingDate;

    @Basic
    @Column(name="VALUE_DATE")
    private String valueDate;


    @Column(name="TYPE_UID")
    private String typeUid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TYPE_UID", referencedColumnName = "UID",insertable=false, updatable=false)
    private TypeEntity typeEntity;


    @Column(name="AMOUNT")
    private Double amount;

    @Column(name="CURRENCY")
    private String currency;

    @Column(name="DESCRIZIONE")
    private String description;


    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPayloadUid() {
        return payloadUid;
    }

    public void setPayloadUid(String payloadUid) {
        this.payloadUid = payloadUid;
    }

    public PayloadEntity getPayloadEntity() {
        return payloadEntity;
    }

    public void setPayloadEntity(PayloadEntity payloadEntity) {
        this.payloadEntity = payloadEntity;
    }

    public String getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(String accountingDate) {
        this.accountingDate = accountingDate;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public String getTypeUid() {
        return typeUid;
    }

    public void setTypeUid(String typeUid) {
        this.typeUid = typeUid;
    }

    public TypeEntity getTypeEntity() {
        return typeEntity;
    }

    public void setTypeEntity(TypeEntity typeEntity) {
        this.typeEntity = typeEntity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
