package com.keyfeni.order.controller;


import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.order.model.CustOrd;
import com.keyfeni.order.repository.CustOrdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CustOrdController {

    @Autowired
    private CustOrdRepository custOrdRepository;


    @GetMapping("/order")
    public Page<CustOrd> getCustOrds(Pageable pageable) {
        return custOrdRepository.findAll(pageable);
    }


    @PostMapping("/order")
    public CustOrd createCustOrd(@Valid @RequestBody CustOrd custOrd) {
        return custOrdRepository.save(custOrd);
    }

    @PutMapping("/order/{id}")
    public CustOrd updateCustOrd(@PathVariable Long id,
                                 @Valid @RequestBody CustOrd custOrdRequest) {
        return custOrdRepository.findById(id)
                .map(custOrd -> {
                    custOrd.setKullaniciAdresId(custOrdRequest.getKullaniciAdresId());
                    return custOrdRepository.save(custOrd);
                }).orElseThrow(() -> new ResourceNotFoundException("CustOrd not found with id " + id));
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<?> deleteCustOrd(@PathVariable Long id) {
        return custOrdRepository.findById(id)
                .map(custOrd -> {
                    custOrdRepository.delete(custOrd);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("CustOrd not found with id " + id));
    }



}

