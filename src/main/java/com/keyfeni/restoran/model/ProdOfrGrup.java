package com.keyfeni.restoran.model;


import com.keyfeni.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROD_OFR_GRUP")
public class ProdOfrGrup extends BaseEntity {

    private String name;
    private Long restoranId; // TODO: bu mantık düşünülecek

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "RESTORAN_ID")
    public Long getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(Long restoranId) {
        this.restoranId = restoranId;
    }
}
