package com.keyfeni.restoran.model;


import com.keyfeni.common.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "PROD_OFR")
public class ProdOfr extends BaseEntity {

    private Long id;
    private Long restoranId; // TODO: bu mantık düşünülecek
    private String name;
    private Double price;


    @Id
    @GeneratedValue(generator = "prod_ofr_generator")
    @SequenceGenerator(
            name = "prod_ofr_generator",
            sequenceName = "prod_ofr_seq",
            initialValue = 1
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "RESTORAN_ID")
    public Long getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(Long restoranId) {
        this.restoranId = restoranId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
