package com.keyfeni.order.repository;

import com.keyfeni.order.model.CustOrdItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustOrdItemRepository extends JpaRepository<CustOrdItem, Long> {

}
