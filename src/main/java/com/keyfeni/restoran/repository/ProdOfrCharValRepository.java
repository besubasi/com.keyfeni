package com.keyfeni.restoran.repository;

import com.keyfeni.restoran.model.ProdOfrCharVal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdOfrCharValRepository extends JpaRepository<ProdOfrCharVal, Long> {

}
