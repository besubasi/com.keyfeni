package com.keyfeni.restoran.model;

import com.keyfeni.common.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RESTORAN")
public class Restoran extends BaseEntity {

    private String email;
    private String password;
    private String name;
    private String aciklama;

    // TODO: açılış kapanış saati olsun.
    // TODO: aktif pasif olsun manuel açıp kapatabilsin


    public Restoran() {
    }

    public Restoran(String email, String password, String name, String aciklama) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.aciklama = aciklama;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }


    @Override
    public String toString() {
        return "Restoran{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", aciklama='" + aciklama + '\'' +
                '}';
    }
}
