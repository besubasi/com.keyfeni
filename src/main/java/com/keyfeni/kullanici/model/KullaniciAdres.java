package com.keyfeni.kullanici.model;


import com.keyfeni.common.model.BaseEntity;
import com.keyfeni.adres.model.Ilce;
import com.keyfeni.adres.model.Mahalle;
import com.keyfeni.adres.model.Sehir;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "KULLANICI_ADRES")
public class KullaniciAdres extends BaseEntity {

    private Long id;
    private Long kullaniciId;
    private Sehir sehir;
    private Ilce ilce;
    private Mahalle mahalle;
    private String name;
    private String adres;


    @Id
    @GeneratedValue(generator = "kullanici_adres_generator")
    @SequenceGenerator(
            name = "kullanici_adres_generator",
            sequenceName = "kullanici_adres_seq",
            initialValue = 1
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "KULLANICI_ID")
    public Long getKullaniciId() {
        return kullaniciId;
    }


    public void setKullaniciId(Long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sehir_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public Sehir getSehir() {
        return sehir;
    }

    public void setSehir(Sehir sehir) {
        this.sehir = sehir;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ilce_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public Ilce getIlce() {
        return ilce;
    }

    public void setIlce(Ilce ilce) {
        this.ilce = ilce;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mahelle_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public Mahalle getMahalle() {
        return mahalle;
    }

    public void setMahalle(Mahalle mahalle) {
        this.mahalle = mahalle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

}
