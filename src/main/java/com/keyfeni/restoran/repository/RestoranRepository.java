package com.keyfeni.restoran.repository;

import com.keyfeni.restoran.model.Restoran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestoranRepository extends JpaRepository<Restoran, Long> {

    Restoran findByEmail(String email);
}
