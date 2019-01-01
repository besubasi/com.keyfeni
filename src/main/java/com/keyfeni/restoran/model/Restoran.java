package com.keyfeni.restoran.model;

import com.keyfeni.common.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "RESTORAN")
public class Restoran extends BaseEntity {

    private Long id;
    private String name;
    private String email;
    private String password;
    // TODO: açılış kapanış saati olsun.
    // TODO: aktif pasif olsun manuel açıp kapatabilsin


    @Id
    @GeneratedValue(generator = "restoran_generator")
    @SequenceGenerator(
            name = "restoran_generator",
            sequenceName = "restoran_seq",
            initialValue = 1
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
