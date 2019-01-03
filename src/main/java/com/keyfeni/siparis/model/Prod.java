package com.keyfeni.siparis.model;

import com.keyfeni.common.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROD")
public class Prod extends BaseEntity {

    private Long siparisId;
    private Long kullaniciId;
    private Long prodOfrId;
    private String name;

    public Long getSiparisId() {
        return siparisId;
    }

    public void setSiparisId(Long siparisId) {
        this.siparisId = siparisId;
    }

    public Long getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public Long getProdOfrId() {
        return prodOfrId;
    }

    public void setProdOfrId(Long prodOfrId) {
        this.prodOfrId = prodOfrId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
