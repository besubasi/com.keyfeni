package com.keyfeni.restoran.controller;

import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.restoran.model.ProdOfr;
import com.keyfeni.restoran.repository.ProdOfrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProdOfrController {

    @Autowired
    private ProdOfrRepository prodOfrRepository;


    @GetMapping("/prodOfr")
    public Page<ProdOfr> getProdOfrs(Pageable pageable) {
        return prodOfrRepository.findAll(pageable);
    }


    @PostMapping("/prodOfr")
    public ProdOfr createProdOfr(@Valid @RequestBody ProdOfr prodOfr) {
        return prodOfrRepository.save(prodOfr);
    }

    @PutMapping("/prodOfr/{prodOfrId}")
    public ProdOfr updateProdOfr(@PathVariable Long prodOfrId,
                                 @Valid @RequestBody ProdOfr prodOfrRequest) {
        return prodOfrRepository.findById(prodOfrId)
                .map(prodOfr -> {
                    prodOfr.setName(prodOfrRequest.getName());
                    prodOfr.setPrice(prodOfrRequest.getPrice());
                    return prodOfrRepository.save(prodOfr);
                }).orElseThrow(() -> new ResourceNotFoundException("ProdOfr not found with id " + prodOfrId));
    }

    @DeleteMapping("/prodOfr/{prodOfrId}")
    public ResponseEntity<?> deleteProdOfr(@PathVariable Long prodOfrId) {
        return prodOfrRepository.findById(prodOfrId)
                .map(prodOfr -> {
                    prodOfrRepository.delete(prodOfr);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("ProdOfr not found with id " + prodOfrId));
    }


}


