package com.keyfeni.restoran.controller;

import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.restoran.model.ProdOfrChar;
import com.keyfeni.restoran.repository.ProdOfrCharRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProdOfrCharController {

    @Autowired
    private ProdOfrCharRepository prodOfrCharRepository;


    @GetMapping("/prodOfrChar")
    public Page<ProdOfrChar> getProdOfrChars(Pageable pageable) {
        return prodOfrCharRepository.findAll(pageable);
    }


    @PostMapping("/prodOfrChar")
    public ProdOfrChar createProdOfrChar(@Valid @RequestBody ProdOfrChar prodOfrChar) {
        return prodOfrCharRepository.save(prodOfrChar);
    }

    @PutMapping("/prodOfrChar/{prodOfrCharId}")
    public ProdOfrChar updateProdOfrChar(@PathVariable Long prodOfrCharId,
                                         @Valid @RequestBody ProdOfrChar prodOfrCharRequest) {
        return prodOfrCharRepository.findById(prodOfrCharId)
                .map(prodOfrChar -> {
                    prodOfrChar.setName(prodOfrCharRequest.getName());
                    return prodOfrCharRepository.save(prodOfrChar);
                }).orElseThrow(() -> new ResourceNotFoundException("ProdOfrChar not found with id " + prodOfrCharId));
    }

    @DeleteMapping("/prodOfrChar/{prodOfrCharId}")
    public ResponseEntity<?> deleteProdOfrChar(@PathVariable Long prodOfrCharId) {
        return prodOfrCharRepository.findById(prodOfrCharId)
                .map(prodOfrChar -> {
                    prodOfrCharRepository.delete(prodOfrChar);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("ProdOfrChar not found with id " + prodOfrCharId));
    }


}



