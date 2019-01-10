package com.keyfeni.adres.repository;

import com.keyfeni.adres.model.Mahalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MahalleRepository extends JpaRepository<Mahalle, Long> {
    List<Mahalle> findByIlceId(Long ilceId);
}
