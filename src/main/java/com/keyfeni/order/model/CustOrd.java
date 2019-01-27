package com.keyfeni.order.model;


import com.keyfeni.common.enums.EnumCustOrdStatus;
import com.keyfeni.common.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CUST_ORD")
public class CustOrd extends BaseEntity {

    private Long restoranId;
    private Long kullaniciId;
    private Long kullaniciAdresId;
    private Date date;
    private EnumCustOrdStatus status;

    @Column(name = "RESTORAN_ID", nullable = false)
    public Long getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(Long restoranId) {
        this.restoranId = restoranId;
    }

    @Column(name = "KULLANICI_ID", nullable = false)
    public Long getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    @Column(name = "KULLANICI_ADRES_ID", nullable = false)
    public Long getKullaniciAdresId() {
        return kullaniciAdresId;
    }

    public void setKullaniciAdresId(Long kullaniciAdresId) {
        this.kullaniciAdresId = kullaniciAdresId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Enumerated(EnumType.STRING)
    public EnumCustOrdStatus getStatus() {
        return status;
    }

    public void setStatus(EnumCustOrdStatus status) {
        this.status = status;
    }
}
