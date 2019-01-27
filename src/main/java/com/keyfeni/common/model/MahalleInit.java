package com.keyfeni.common.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MAHALLE_INIT")
public class MahalleInit extends BaseEntity {

    private String sehir;
    private String ilce;
    private String semt;
    private String mahalle;

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getSemt() {
        return semt;
    }

    public void setSemt(String semt) {
        this.semt = semt;
    }

    public String getMahalle() {
        return mahalle;
    }

    public void setMahalle(String mahalle) {
        this.mahalle = mahalle;
    }
}
