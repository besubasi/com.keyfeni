package com.keyfeni.order.model;

import com.keyfeni.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CUST_ORD_ITEM_CHAR")
public class CustOrdItemChar extends BaseEntity {

    private Long custOrdId;
    private Long custOrdItemId;
    private Long prodOfrCharId;


    @Column(name = "CUST_ORD_ID", nullable = false)
    public Long getCustOrdId() {
        return custOrdId;
    }

    public void setCustOrdId(Long custOrdId) {
        this.custOrdId = custOrdId;
    }

    @Column(name = "CUST_ORD_ITEM_ID", nullable = false)
    public Long getCustOrdItemId() {
        return custOrdItemId;
    }

    public void setCustOrdItemId(Long custOrdItemId) {
        this.custOrdItemId = custOrdItemId;
    }

    @Column(name = "PROD_OFR_CHAR_ID", nullable = false)
    public Long getProdOfrCharId() {
        return prodOfrCharId;
    }

    public void setProdOfrCharId(Long prodOfrCharId) {
        this.prodOfrCharId = prodOfrCharId;
    }
}
