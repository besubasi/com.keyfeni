package com.keyfeni.siparis.repository;

import com.keyfeni.siparis.model.Prod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdRepository extends JpaRepository<Prod, Long> {
}
