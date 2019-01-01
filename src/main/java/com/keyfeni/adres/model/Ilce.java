package com.keyfeni.adres.model;


import com.keyfeni.common.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "ILCE")
public class Ilce extends BaseEntity {

    private Long id;
    private Sehir sehir;
    private String name;


    @Id
    @GeneratedValue(generator = "ilce_generator")
    @SequenceGenerator(
            name = "ilce_generator",
            sequenceName = "ilce_seq",
            initialValue = 1
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SEHIR_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public Sehir getSehir() {
        return sehir;
    }

    public void setSehir(Sehir sehir) {
        this.sehir = sehir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

