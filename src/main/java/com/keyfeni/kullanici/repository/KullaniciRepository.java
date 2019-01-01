package com.keyfeni.kullanici.repository;

import com.keyfeni.kullanici.model.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KullaniciRepository extends JpaRepository<Kullanici, Long> {
}
