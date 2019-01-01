package com.keyfeni.restoran.model;


import com.keyfeni.common.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "PROD_OFR_CHAR")
public class ProdOfrChar extends BaseEntity {

    private Long id;
    private Long prodOfrId;
    private String name;

    @Id
    @GeneratedValue(generator = "prod_ofr_char_generator")
    @SequenceGenerator(
            name = "prod_ofr_char_generator",
            sequenceName = "prod_ofr_char_seq",
            initialValue = 1
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "PROD_OFR_ID")
    public Long getProdOfrId() {
        return prodOfrId;
    }

    public void setProdOfrId(Long prodOfrId) {
        this.prodOfrId = prodOfrId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
