package com.keyfeni.restoran.repository;

import com.keyfeni.restoran.model.ProdOfr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdOfrRepository extends JpaRepository<ProdOfr, Long> {

}
