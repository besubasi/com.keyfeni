package com.keyfeni.siparis.model;

import com.keyfeni.common.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "PROD")
public class Prod extends BaseEntity {

    private Long id;
    private Long prodOfrId;



    @Id
    @GeneratedValue(generator = "prod_generator")
    @SequenceGenerator(
            name = "prod_generator",
            sequenceName = "prod_seq",
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
}
