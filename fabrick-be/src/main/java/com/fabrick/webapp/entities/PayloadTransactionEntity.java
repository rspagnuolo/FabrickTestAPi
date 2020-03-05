
package com.fabrick.webapp.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="PAYLOADTRANSACTION")
public class PayloadTransactionEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="UID")
    private String uid;

    @Basic
    @Column(name="STATUS")
    private String status;

    @Column(name="PAYLOAD_UID")
    private String payloadUid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PAYLOAD_UID", referencedColumnName = "UID")
    private PayloadEntity payloadEntity;

    @Column(name="ERROR")
    @ElementCollection(targetClass=String.class)
    private List<String> errors = null;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PayloadEntity getPayloadEntity() {
        return payloadEntity;
    }

    public void setPayloadEntity(PayloadEntity payloadEntity) {
        this.payloadEntity = payloadEntity;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getPayloadUid() {
        return payloadUid;
    }

    public void setPayloadUid(String payloadUid) {
        this.payloadUid = payloadUid;
    }
}
