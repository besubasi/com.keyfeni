package com.keyfeni.siparis.model;

import com.keyfeni.common.enums.EnumPuanTuru;
import com.keyfeni.common.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "PUAN")
public class Puan extends BaseEntity {

    private Long kullaniciId;
    private Long restoranId;
    private Long siparisId; // siparis yada yemek
    private Long prodOfrId;
    private String yorum;
    private EnumPuanTuru puanTuru; // TODO enum olacak
    private short puan;

    public Long getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public Long getRestoranId() {
        return restoranId;
    }

    public void setRestoranId(Long restoranId) {
        this.restoranId = restoranId;
    }

    public Long getSiparisId() {
        return siparisId;
    }

    public void setSiparisId(Long siparisId) {
        this.siparisId = siparisId;
    }

    public Long getProdOfrId() {
        return prodOfrId;
    }

    public void setProdOfrId(Long prodOfrId) {
        this.prodOfrId = prodOfrId;
    }

    @Column(name = "yorum", length = 4000 )
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
