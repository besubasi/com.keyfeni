package com.keyfeni.siparis.repository;

import com.keyfeni.siparis.model.ProdChar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdCharRepository extends JpaRepository<ProdChar, Long> {
}