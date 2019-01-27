package com.keyfeni.order.controller;


import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.order.model.CustOrdItem;
import com.keyfeni.order.repository.CustOrdItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CustOrdItemController {

    @Autowired
    private CustOrdItemRepository custOrdItemRepository;


    @GetMapping("/order-item")
    public Page<CustOrdItem> getCustOrdItems(Pageable pageable) {
        return custOrdItemRepository.findAll(pageable);
    }


    @PostMapping("/order-item")
    public CustOrdItem createCustOrdItem(@Valid @RequestBody CustOrdItem custOrdItem) {
        return custOrdItemRepository.save(custOrdItem);
    }

    @PutMapping("/order-item/{id}")
    public CustOrdItem updateCustOrdItem(@PathVariable Long id,
                                 @Valid @RequestBody CustOrdItem custOrdItemRequest) {
        return custOrdItemRepository.findById(id)
                .map(custOrdItem -> {
                    custOrdItem.setAdet(custOrdItemRequest.getAdet());
                    return custOrdItemRepository.save(custOrdItem);
                }).orElseThrow(() -> new ResourceNotFoundException("CustOrdItem not found with id " + id));
    }

    @DeleteMapping("/order-item/{id}")
    public ResponseEntity<?> deleteCustOrdItem(@PathVariable Long id) {
        return custOrdItemRepository.findById(id)
                .map(custOrdItem -> {
                    custOrdItemRepository.delete(custOrdItem);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("CustOrdItem not found with id " + id));
    }



}

