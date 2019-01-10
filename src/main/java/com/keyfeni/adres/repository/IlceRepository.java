package com.keyfeni.adres.repository;

import com.keyfeni.adres.model.Ilce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IlceRepository extends JpaRepository<Ilce, Long> {
    List<Ilce> findBySehirId(Long sehirId);

}
