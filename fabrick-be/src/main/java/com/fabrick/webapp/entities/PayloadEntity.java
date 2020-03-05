
package com.fabrick.webapp.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="PAYLOAD")
public class PayloadEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="UID")
    private String uid;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "payloadEntity")
    private List<TransactionEntity> list;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<TransactionEntity> getList() {
        return list;
    }

    public void setList(List<TransactionEntity> list) {
        this.list = list;
    }
}
