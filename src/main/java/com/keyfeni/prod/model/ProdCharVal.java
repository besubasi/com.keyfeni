package com.keyfeni.prod.model;

import com.keyfeni.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROD_CHAR_VAL")
public class ProdCharVal extends BaseEntity {

    private Long prodId;
    private Long prodCharId;
    private String val;
    private Double price;

    @Column(name = "PROD_ID" , nullable = false)
    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    @Column(name = "PROD_CHAR_ID" , nullable = false)
    public Long getProdCharId() {
        return prodCharId;
    }

    public void setProdCharId(Long prodCharId) {
        this.prodCharId = prodCharId;
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
}
