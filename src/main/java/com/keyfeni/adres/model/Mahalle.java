package com.keyfeni.adres.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.keyfeni.common.model.BaseEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "MAHALLE")
public class Mahalle extends BaseEntity {

    private Sehir sehir;
    private Ilce ilce;
    private Semt semt;
    private String name;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ILCE_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public Ilce getIlce() {
        return ilce;
    }

    public void setIlce(Ilce ilce) {
        this.ilce = ilce;
    }


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SEMT_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public Semt getSemt() {
        return semt;
    }

    public void setSemt(Semt semt) {
        this.semt = semt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

