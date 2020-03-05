
package com.fabrick.webapp.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TYPEVALUE")
public class TypeEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="UID")
    private String uid;

    @Column(name="ENUMERATION")
    private String enumeration;

    @Column(name="VALUE")
    private String value;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEnumeration() {
        return enumeration;
    }

    public void setEnumeration(String enumeration) {
        this.enumeration = enumeration;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
