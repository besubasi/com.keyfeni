package com.keyfeni.prod.model;

import com.keyfeni.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROD")
public class Prod extends BaseEntity {

    private Long kullaniciId;
    private Long custOrdId;
    private Long prodOfrId;
    private String name;
    private Double tutar;
    private Integer adet;

    @Column(name = "KULLANICI_ID" , nullable = false)
    public Long getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    @Column(name = "CUST_ORD_ID" , nullable = false)
    public Long getCustOrdId() {
        return custOrdId;
    }

    public void setCustOrdId(Long custOrdId) {
        this.custOrdId = custOrdId;
    }

    @Column(name = "PROD_OFR_ID" , nullable = false)
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

    public Double getTutar() {
        return tutar;
    }

    public void setTutar(Double tutar) {
        this.tutar = tutar;
    }

    public Integer getAdet() {
        return adet;
    }

    public void setAdet(Integer adet) {
        this.adet = adet;
    }
}
