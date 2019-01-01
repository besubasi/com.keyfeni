package com.keyfeni.adres.model;

import com.keyfeni.common.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "SEHIR")
public class Sehir extends BaseEntity {

    private Long id;
    private String name;

    @Id
    @GeneratedValue(generator = "sehir_generator")
    @SequenceGenerator(
            name = "sehir_generator",
            sequenceName = "sehir_seq",
            initialValue = 1
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
