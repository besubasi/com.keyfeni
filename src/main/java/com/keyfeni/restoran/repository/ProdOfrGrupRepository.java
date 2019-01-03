package com.keyfeni.restoran.repository;

import com.keyfeni.restoran.model.ProdOfrGrup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdOfrGrupRepository extends JpaRepository<ProdOfrGrup, Long> {
}
