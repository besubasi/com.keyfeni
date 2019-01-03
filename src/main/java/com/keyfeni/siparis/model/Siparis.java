package com.keyfeni.siparis.model;


import com.keyfeni.common.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "SIPARIS")
public class Siparis extends BaseEntity {

    private Long kullaniciId;
    private Long kullaniciAdresId;
    private Long restoranId;
    private Date date;

    public Long getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public Long getKullaniciAdresId() {
        return kullaniciAdresId;
    }

    public void setKullaniciAdresId(Long kullaniciAdresId) {
        this.kullaniciAdresId = kullaniciAdresId;
    }

    public Long getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(Long restoranId) {
        this.restoranId = restoranId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
