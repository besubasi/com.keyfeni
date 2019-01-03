package com.keyfeni.restoran.model;

import com.keyfeni.common.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RESTORAN_ODEME_SEKLI")
public class RestoranOdemeSekli extends BaseEntity {

    private Long restoranId;
    private Long odemeSekliId;

    public Long getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(Long restoranId) {
        this.restoranId = restoranId;
    }

    public Long getOdemeSekliId() {
        return odemeSekliId;
    }

    public void setOdemeSekliId(Long odemeSekliId) {
        this.odemeSekliId = odemeSekliId;
    }
}
