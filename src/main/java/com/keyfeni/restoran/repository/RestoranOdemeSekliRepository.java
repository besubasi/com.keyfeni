package com.keyfeni.restoran.repository;

import com.keyfeni.restoran.model.RestoranOdemeSekli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestoranOdemeSekliRepository extends JpaRepository<RestoranOdemeSekli, Long> {
}
