package com.keyfeni.prod.repository;

import com.keyfeni.prod.model.ProdChar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdCharRepository extends JpaRepository<ProdChar, Long> {
}