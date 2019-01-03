package com.keyfeni.siparis.model;

import com.keyfeni.common.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROD_CHAR")
public class ProdChar extends BaseEntity {

    private Long prodId;
    private Long prodOfrId;
    private Long prodOfrCharId;
    private String name;

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public Long getProdOfrId() {
        return prodOfrId;
    }

    public void setProdOfrId(Long prodOfrId) {
        this.prodOfrId = prodOfrId;
    }

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
