package com.keyfeni.restoran.controller;

import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.restoran.model.ProdOfrCharVal;
import com.keyfeni.restoran.repository.ProdOfrCharValRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProdOfrCharValController {

    @Autowired
    private ProdOfrCharValRepository prodOfrCharValRepository;


    @GetMapping("/prodOfrCharVal")
    public Page<ProdOfrCharVal> getProdOfrCharVals(Pageable pageable) {
        return prodOfrCharValRepository.findAll(pageable);
    }


    @PostMapping("/prodOfrCharVal")
    public ProdOfrCharVal createProdOfrCharVal(@Valid @RequestBody ProdOfrCharVal prodOfrCharVal) {
        return prodOfrCharValRepository.save(prodOfrCharVal);
    }

    @PutMapping("/prodOfrCharVal/{prodOfrCharValId}")
    public ProdOfrCharVal updateProdOfrCharVal(@PathVariable Long prodOfrCharValId,
                                               @Valid @RequestBody ProdOfrCharVal prodOfrCharValRequest) {
        return prodOfrCharValRepository.findById(prodOfrCharValId)
                .map(prodOfrCharVal -> {
                    prodOfrCharVal.setVal(prodOfrCharValRequest.getVal());
                    prodOfrCharVal.setPrice(prodOfrCharValRequest.getPrice());
                    return prodOfrCharValRepository.save(prodOfrCharVal);
                }).orElseThrow(() -> new ResourceNotFoundException("ProdOfrCharVal not found with id " + prodOfrCharValId));
    }

    @DeleteMapping("/prodOfrCharVal/{prodOfrCharValId}")
    public ResponseEntity<?> deleteProdOfrCharVal(@PathVariable Long prodOfrCharValId) {
        return prodOfrCharValRepository.findById(prodOfrCharValId)
                .map(prodOfrCharVal -> {
                    prodOfrCharValRepository.delete(prodOfrCharVal);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("ProdOfrCharVal not found with id " + prodOfrCharValId));
    }


}



