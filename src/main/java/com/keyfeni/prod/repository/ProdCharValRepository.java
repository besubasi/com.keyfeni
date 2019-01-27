package com.keyfeni.prod.repository;

import com.keyfeni.prod.model.ProdCharVal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdCharValRepository extends JpaRepository<ProdCharVal, Long> {
}