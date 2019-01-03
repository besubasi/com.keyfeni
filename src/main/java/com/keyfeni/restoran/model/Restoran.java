package com.keyfeni.restoran.model;

import com.keyfeni.common.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RESTORAN")
public class Restoran extends BaseEntity {

    private String name;
    private String email;
    private String password;
    private String aciklama;

    // TODO: açılış kapanış saati olsun.
    // TODO: aktif pasif olsun manuel açıp kapatabilsin


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
}
