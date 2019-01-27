package com.keyfeni.order.controller;


import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.order.model.CustOrdItemChar;
import com.keyfeni.order.repository.CustOrdItemCharRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CustOrdItemCharController {

    @Autowired
    private CustOrdItemCharRepository custOrdItemCharRepository;


    @GetMapping("/order-item-char")
    public Page<CustOrdItemChar> getCustOrdItemChars(Pageable pageable) {
        return custOrdItemCharRepository.findAll(pageable);
    }


    @PostMapping("/order-item-char")
    public CustOrdItemChar createCustOrdItemChar(@Valid @RequestBody CustOrdItemChar custOrdItemChar) {
        return custOrdItemCharRepository.save(custOrdItemChar);
    }

    @PutMapping("/order-item-char/{id}")
    public CustOrdItemChar updateCustOrdItemChar(@PathVariable Long id,
                                         @Valid @RequestBody CustOrdItemChar custOrdItemCharRequest) {
        return custOrdItemCharRepository.findById(id)
                .map(custOrdItemChar -> {
                    custOrdItemChar.setCustOrdItemId(custOrdItemCharRequest.getCustOrdItemId());
                    custOrdItemChar.setProdOfrCharId(custOrdItemCharRequest.getProdOfrCharId());
                    return custOrdItemCharRepository.save(custOrdItemChar);
                }).orElseThrow(() -> new ResourceNotFoundException("CustOrdItemChar not found with id " + id));
    }

    @DeleteMapping("/order-item-char/{id}")
    public ResponseEntity<?> deleteCustOrdItemChar(@PathVariable Long id) {
        return custOrdItemCharRepository.findById(id)
                .map(custOrdItemChar -> {
                    custOrdItemCharRepository.delete(custOrdItemChar);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("CustOrdItemChar not found with id " + id));
    }



}

