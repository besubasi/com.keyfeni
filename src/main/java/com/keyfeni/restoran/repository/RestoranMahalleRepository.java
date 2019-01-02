package com.keyfeni.restoran.repository;

import com.keyfeni.restoran.model.RestoranMahalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestoranMahalleRepository extends JpaRepository<RestoranMahalle, Long> {

}
