package com.keyfeni.restoran.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.keyfeni.adres.model.Ilce;
import com.keyfeni.adres.model.Mahalle;
import com.keyfeni.adres.model.Sehir;
import com.keyfeni.adres.model.Semt;
import com.keyfeni.common.model.BaseEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "RESTORAN_MAHALLE")
public class RestoranMahalle extends BaseEntity {

    private Restoran restoran;
    private Sehir sehir;
    private Ilce ilce;
    private Semt semt;
    private Mahalle mahalle;
    private Integer minimumTutar;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RESTORAN_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MAHALLE_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public Mahalle getMahalle() {
        return mahalle;
    }

    public void setMahalle(Mahalle mahalle) {
        this.mahalle = mahalle;
    }

    @Column(name = "MINIMUM_TUTAR")
    public Integer getMinimumTutar() {
        return minimumTutar;
    }

    public void setMinimumTutar(Integer minimumTutar) {
        this.minimumTutar = minimumTutar;
    }
}
