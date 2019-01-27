package com.keyfeni.kullanici.repository;

import com.keyfeni.kullanici.model.Puan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuanRepository extends JpaRepository<Puan, Long> {
}
