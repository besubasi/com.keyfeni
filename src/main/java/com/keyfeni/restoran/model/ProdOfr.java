package com.keyfeni.restoran.model;


import com.keyfeni.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROD_OFR")
public class ProdOfr extends BaseEntity {

    private Long prodOfrGrupId;
    private Long restoranId;
    private String name;
    private String aciklama;
    private Double price;

    @Column(name = "PROD_OFR_GRUP_ID", nullable = false)
    public Long getProdOfrGrupId() {
        return prodOfrGrupId;
    }

    public void setProdOfrGrupId(Long prodOfrGrupId) {
        this.prodOfrGrupId = prodOfrGrupId;
    }

    @Column(name = "RESTORAN_ID", nullable = false)
    public Long getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(Long restoranId) {
        this.restoranId = restoranId;
    }

    @Column(name = "NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
