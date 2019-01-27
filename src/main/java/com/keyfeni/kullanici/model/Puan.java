package com.keyfeni.kullanici.model;

import com.keyfeni.common.enums.EnumPuanTuru;
import com.keyfeni.common.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "PUAN")
public class Puan extends BaseEntity {

    private Long kullaniciId;
    private Long restoranId;
    private Long prodOfrId;
    private String yorum;
    private EnumPuanTuru puanTuru;
    private short puan;

    @Column(name = "KULLANICI_ID", nullable = false)
    public Long getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    @Column(name = "RESTORAN_ID", nullable = false)
    public Long getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(Long restoranId) {
        this.restoranId = restoranId;
    }

    @Column(name = "PROD_OFR__ID", nullable = false)
    public Long getProdOfrId() {
        return prodOfrId;
    }

    public void setProdOfrId(Long prodOfrId) {
        this.prodOfrId = prodOfrId;
    }

    @Column(name = "YORUM", length = 4000 )
    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }

    @Enumerated(value = EnumType.STRING)
    public EnumPuanTuru getPuanTuru() {
        return puanTuru;
    }

    public void setPuanTuru(EnumPuanTuru puanTuru) {
        this.puanTuru = puanTuru;
    }

    public short getPuan() {
        return puan;
    }

    public void setPuan(short puan) {
        this.puan = puan;
    }
}
