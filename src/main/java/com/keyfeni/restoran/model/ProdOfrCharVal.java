package com.keyfeni.restoran.model;

import com.keyfeni.common.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "PROD_OFR_CHAR_VAL")
public class ProdOfrCharVal extends BaseEntity {

    private Long id;
    private Long prodOfrId;
    private Long prodOfrCharId;
    private String val;
    private Double price;


    @Id
    @GeneratedValue(generator = "prod_ofr_char_val_generator")
    @SequenceGenerator(
            name = "prod_ofr_char_val_generator",
            sequenceName = "prod_ofr_char_val_seq",
            initialValue = 1
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
