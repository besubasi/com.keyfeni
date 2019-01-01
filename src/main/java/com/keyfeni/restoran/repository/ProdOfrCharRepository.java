package com.keyfeni.restoran.repository;

import com.keyfeni.restoran.model.ProdOfrChar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdOfrCharRepository extends JpaRepository<ProdOfrChar, Long> {
}
