package com.keyfeni.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"CDATE", "UDATE"},
        allowGetters = true
)
public class BaseEntity implements Serializable {

    private Date cdate;
    private Date udate;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CDATE", nullable = false, updatable = false)
    @CreatedDate
    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UDATE", nullable = false)
    @LastModifiedDate
    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }


}
