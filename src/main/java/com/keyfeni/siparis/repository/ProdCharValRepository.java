package com.keyfeni.siparis.repository;

import com.keyfeni.siparis.model.ProdCharVal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdCharValRepository extends JpaRepository<ProdCharVal, Long> {
}