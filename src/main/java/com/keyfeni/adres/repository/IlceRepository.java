package com.keyfeni.adres.repository;

import com.keyfeni.adres.model.Ilce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IlceRepository extends JpaRepository<Ilce, Long> {
    List<Ilce> findBySehirId(Long sehirId);

}
