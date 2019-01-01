package com.keyfeni.siparis.model;


import com.keyfeni.common.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SIPARIS")
public class Siparis extends BaseEntity {

    private Long id;
    private Long kullaniciId;
    private Long kullaniciAdresId;
    private Long restoranId;
    private Date date;

    @Id
    @GeneratedValue(generator = "siparis_generator")
    @SequenceGenerator(
            name = "siparis_generator",
            sequenceName = "siparis_seq",
            initialValue = 1
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
