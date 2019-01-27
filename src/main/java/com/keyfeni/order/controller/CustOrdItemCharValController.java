package com.keyfeni.order.controller;


import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.order.model.CustOrdItemCharVal;
import com.keyfeni.order.repository.CustOrdItemCharValRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CustOrdItemCharValController {

    @Autowired
    private CustOrdItemCharValRepository custOrdItemCharValRepository;


    @GetMapping("/order-item-char-val")
    public Page<CustOrdItemCharVal> getCustOrdItemCharVals(Pageable pageable) {
        return custOrdItemCharValRepository.findAll(pageable);
    }


    @PostMapping("/order-item-char-val")
    public CustOrdItemCharVal createCustOrdItemCharVal(@Valid @RequestBody CustOrdItemCharVal custOrdItemCharVal) {
        return custOrdItemCharValRepository.save(custOrdItemCharVal);
    }

    @PutMapping("/order-item-char-val/{id}")
    public CustOrdItemCharVal updateCustOrdItemCharVal(@PathVariable Long id,
                                                 @Valid @RequestBody CustOrdItemCharVal custOrdItemCharValRequest) {
        return custOrdItemCharValRepository.findById(id)
                .map(custOrdItemCharVal -> {
                    custOrdItemCharVal.setDeleted(custOrdItemCharValRequest.getDeleted());
                    return custOrdItemCharValRepository.save(custOrdItemCharVal);
                }).orElseThrow(() -> new ResourceNotFoundException("CustOrdItemCharVal not found with id " + id));
    }

    @DeleteMapping("/order-item-char-val/{id}")
    public ResponseEntity<?> deleteCustOrdItemCharVal(@PathVariable Long id) {
        return custOrdItemCharValRepository.findById(id)
                .map(custOrdItemCharVal -> {
                    custOrdItemCharValRepository.delete(custOrdItemCharVal);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("CustOrdItemCharVal not found with id " + id));
    }



}

