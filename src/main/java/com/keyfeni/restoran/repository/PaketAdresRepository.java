package com.keyfeni.restoran.repository;

import com.keyfeni.restoran.model.PaketAdres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaketAdresRepository extends JpaRepository<PaketAdres, Long> {

}
