package com.keyfeni.kullanici.model;


import com.keyfeni.common.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "KULLANICI")
public class Kullanici extends BaseEntity {

    private Long id;
    private String name;
    private String email;
    private String password;

    @Id
    @GeneratedValue(generator = "kullanici_generator")
    @SequenceGenerator(
            name = "kullanici_generator",
            sequenceName = "kullanici_seq",
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
