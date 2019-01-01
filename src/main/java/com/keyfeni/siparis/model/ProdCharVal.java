package com.keyfeni.siparis.model;

import com.keyfeni.common.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "PROD_CHAR_VAL")
public class ProdCharVal extends BaseEntity {

    private Long id;
    private Long prodCharId;
    private Long prodId;
    private String val;
    private Double price;

    @Id
    @GeneratedValue(generator = "prod_char_val_generator")
    @SequenceGenerator(
            name = "prod_char_val_generator",
            sequenceName = "prod_char_val_seq",
            initialValue = 1
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProdCharId() {
        return prodCharId;
    }

    public void setProdCharId(Long prodCharId) {
        this.prodCharId = prodCharId;
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
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
