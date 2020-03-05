package com.fabrick.webapp.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Spagnuolo Roberto on 05/03/20
 */

@Entity
@Table(name="STORICO")
public class StoricoEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @Column(name="UID")
    private String uid;

    @Column(name="PAYLOAD_TRANSACTION_UID")
    private String payloadTranscactionUid;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "PAYLOAD_TRANSACTION_UID", referencedColumnName = "UID" ,insertable=false, updatable=false)
    private PayloadTransactionEntity payloadTransactionEntity;

    @Column(name="OPERATION")
    private String OperationType;

    @Column(name="DATA_OPER")
    private Date data;

    @Column(name="USER_ID")
    private String userId;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPayloadTranscactionUid() {
        return payloadTranscactionUid;
    }

    public void setPayloadTranscactionUid(String payloadTranscactionUid) {
        this.payloadTranscactionUid = payloadTranscactionUid;
    }

    public PayloadTransactionEntity getPayloadTransactionEntity() {
        return payloadTransactionEntity;
    }

    public void setPayloadTransactionEntity(PayloadTransactionEntity payloadTransactionEntity) {
        this.payloadTransactionEntity = payloadTransactionEntity;
    }

    public String getOperationType() {
        return OperationType;
    }

    public void setOperationType(String operationType) {
        OperationType = operationType;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
