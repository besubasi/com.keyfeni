package com.keyfeni.restoran.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.keyfeni.common.model.BaseEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "RESTORAN_ODEME_SEKLI")
public class RestoranOdemeSekli extends BaseEntity {

    private Restoran restoran;
    private OdemeSekli odemeSekli;

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
    @JoinColumn(name = "ODEME_SEKLI_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public OdemeSekli getOdemeSekli() {
        return odemeSekli;
    }

    public void setOdemeSekli(OdemeSekli restoran) {
        this.odemeSekli = odemeSekli;
    }
}
