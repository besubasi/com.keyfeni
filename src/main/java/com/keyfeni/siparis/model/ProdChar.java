package com.keyfeni.siparis.model;

import com.keyfeni.common.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "PROD_CHAR")
public class ProdChar extends BaseEntity {

    private Long id;
    private Long prodId;
    private Long prodOfrId;
    private Long prodOfrCharId;


    @Id
    @GeneratedValue(generator = "prod_char_generator")
    @SequenceGenerator(
            name = "prod_char_generator",
            sequenceName = "prod_char_seq",
            initialValue = 1
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
