package com.keyfeni.restoran.model;

import com.keyfeni.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROD_OFR_CHAR_VAL")
public class ProdOfrCharVal extends BaseEntity {

    private Long prodOfrId;
    private Long prodOfrCharId;
    private String val;
    private Double price;
    private Boolean isDefaultVal;


    @Column(name = "PROD_OFR_ID", nullable = false)
    public Long getProdOfrId() {
        return prodOfrId;
    }

    public void setProdOfrId(Long prodOfrId) {
        this.prodOfrId = prodOfrId;
    }

    @Column(name = "PROD_OFR_CHAR_ID", nullable = false)
    public Long getProdOfrCharId() {
        return prodOfrCharId;
    }

    public void setProdOfrCharId(Long prodOfrCharId) {
        this.prodOfrCharId = prodOfrCharId;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getDefaultVal() {
        return isDefaultVal;
    }

    public void setDefaultVal(Boolean defaultVal) {
        isDefaultVal = defaultVal;
    }
}
