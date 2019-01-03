package com.keyfeni.restoran.repository;

import com.keyfeni.restoran.model.OdemeSekli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdemeSekliRepository extends JpaRepository<OdemeSekli, Long> {

}
