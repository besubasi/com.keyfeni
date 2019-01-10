package com.keyfeni.adres.repository;

import com.keyfeni.adres.model.Sehir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SehirRepository extends JpaRepository<Sehir, Long> {
}
