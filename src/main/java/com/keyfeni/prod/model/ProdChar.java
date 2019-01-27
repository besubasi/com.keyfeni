package com.keyfeni.prod.model;

import com.keyfeni.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROD_CHAR")
public class ProdChar extends BaseEntity {

    private Long prodId;
    private Long prodOfrId;
    private Long prodOfrCharId;
    private String name;

    @Column(name = "PROD_ID" , nullable = false)
    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    @Column(name = "PROD_OFR_ID" , nullable = false)
    public Long getProdOfrId() {
        return prodOfrId;
    }

    public void setProdOfrId(Long prodOfrId) {
        this.prodOfrId = prodOfrId;
    }

    @Column(name = "PROD_OFR_CHAR_ID" , nullable = false)
    public Long getProdOfrCharId() {
        return prodOfrCharId;
    }

    public void setProdOfrCharId(Long prodOfrCharId) {
        this.prodOfrCharId = prodOfrCharId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
