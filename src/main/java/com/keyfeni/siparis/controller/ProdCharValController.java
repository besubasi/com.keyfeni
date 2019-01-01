package com.keyfeni.siparis.controller;


import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.siparis.model.ProdCharVal;
import com.keyfeni.siparis.repository.ProdCharValRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProdCharValController {

    @Autowired
    private ProdCharValRepository prodCharValRepository;


    @GetMapping("/prodCharVal")
    public Page<ProdCharVal> getProdCharVals(Pageable pageable) {
        return prodCharValRepository.findAll(pageable);
    }


    @PostMapping("/prodCharVal")
    public ProdCharVal createProdCharVal(@Valid @RequestBody ProdCharVal prodCharVal) {
        return prodCharValRepository.save(prodCharVal);
    }

    @PutMapping("/prodCharVal/{prodCharValId}")
    public ProdCharVal updateProdCharVal(@PathVariable Long prodCharValId,
                                         @Valid @RequestBody ProdCharVal prodCharValRequest) {
        return prodCharValRepository.findById(prodCharValId)
                .map(prodCharVal -> {
                    prodCharVal.setVal(prodCharValRequest.getVal());
                    prodCharVal.setPrice(prodCharValRequest.getPrice());
                    return prodCharValRepository.save(prodCharVal);
                }).orElseThrow(() -> new ResourceNotFoundException("ProdCharVal not found with id " + prodCharValId));
    }

    @DeleteMapping("/prodCharVal/{prodCharValId}")
    public ResponseEntity<?> deleteProdCharVal(@PathVariable Long prodCharValId) {
        return prodCharValRepository.findById(prodCharValId)
                .map(prodCharVal -> {
                    prodCharValRepository.delete(prodCharVal);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("ProdCharVal not found with id " + prodCharValId));
    }


}



