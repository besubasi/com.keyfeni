package com.keyfeni.adres.repository;

import com.keyfeni.adres.model.Mahalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MahalleRepository extends JpaRepository<Mahalle, Long> {
    List<Mahalle> findByIlceId(Long ilceId);
}
