package com.keyfeni.siparis.repository;

import com.keyfeni.siparis.model.Puan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuanRepository extends JpaRepository<Puan, Long> {
}
