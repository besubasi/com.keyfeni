package com.keyfeni.order.model;

import com.keyfeni.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "CUST_ORD_ITEM_CHAR_VAL")
public class CustOrdItemCharVal extends BaseEntity {

    private Long custOrdItemCharId;
    private Long prodOfrCharValId;

    @Column(name = "CUST_ORD_ITEM_CHAR_ID", nullable = false)
    public Long getCustOrdItemCharId() {
        return custOrdItemCharId;
    }

    public void setCustOrdItemCharId(Long custOrdItemCharId) {
        this.custOrdItemCharId = custOrdItemCharId;
    }

    @Column(name = "PROD_OFR_CHAR_VAL_ID", nullable = false)
    public Long getProdOfrCharValId() {
        return prodOfrCharValId;
    }

    public void setProdOfrCharValId(Long prodOfrCharValId) {
        this.prodOfrCharValId = prodOfrCharValId;
    }

}
