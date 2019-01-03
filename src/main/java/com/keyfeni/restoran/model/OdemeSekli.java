package com.keyfeni.restoran.model;

import com.keyfeni.common.enums.EnumOdemeSekli;
import com.keyfeni.common.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "ODEME_SEKLI")
public class OdemeSekli extends BaseEntity {

    private String name;
    private EnumOdemeSekli kod; // TODO Enum olacak


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(value = EnumType.STRING)
    public EnumOdemeSekli getKod() {
        return kod;
    }

    public void setKod(EnumOdemeSekli kod) {
        this.kod = kod;
    }
}
