package com.keyfeni.restoran.model;


import com.keyfeni.common.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROD_OFR_CHAR")
public class ProdOfrChar extends BaseEntity {

    private Long prodOfrId;
    private String name;
    private Boolean isChecbox;
    private Boolean isChecked;

    @Column(name = "PROD_OFR_ID", nullable = false)
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

    public Boolean getChecbox() {
        return isChecbox;
    }

    public void setChecbox(Boolean checbox) {
        isChecbox = checbox;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }
}
