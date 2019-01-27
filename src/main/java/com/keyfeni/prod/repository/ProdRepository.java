package com.keyfeni.prod.repository;

import com.keyfeni.prod.model.Prod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdRepository extends JpaRepository<Prod, Long> {
}
