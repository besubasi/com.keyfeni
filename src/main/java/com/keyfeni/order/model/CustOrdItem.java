package com.keyfeni.order.model;

import com.keyfeni.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "CUST_ORD_ITEM")
public class CustOrdItem extends BaseEntity {


    private Long custOrdId;
    private Long prodOfrId;
    private Integer adet;


    @Column(name = "CUST_ORD_ID", nullable = false)
    public Long getCustOrdId() {
        return custOrdId;
    }

    public void setCustOrdId(Long custOrdId) {
        this.custOrdId = custOrdId;
    }

    @Column(name = "PROD_OFR_ID", nullable = false)
    public Long getProdOfrId() {
        return prodOfrId;
    }

    public void setProdOfrId(Long prodOfrId) {
        this.prodOfrId = prodOfrId;
    }

    public Integer getAdet() {
        return adet;
    }

    public void setAdet(Integer adet) {
        this.adet = adet;
    }
}
