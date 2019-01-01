package com.keyfeni.siparis.controller;


import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.siparis.model.ProdChar;
import com.keyfeni.siparis.repository.ProdCharRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProdCharController {

    @Autowired
    private ProdCharRepository prodCharRepository;


    @GetMapping("/prodChar")
    public Page<ProdChar> getProdChars(Pageable pageable) {
        return prodCharRepository.findAll(pageable);
    }


    @PostMapping("/prodChar")
    public ProdChar createProdChar(@Valid @RequestBody ProdChar prodChar) {
        return prodCharRepository.save(prodChar);
    }

    @PutMapping("/prodChar/{prodCharId}")
    public ProdChar updateProdChar(@PathVariable Long prodCharId,
                                   @Valid @RequestBody ProdChar prodCharRequest) {
        return prodCharRepository.findById(prodCharId)
                .map(prodChar -> {
                    return prodCharRepository.save(prodChar);
                }).orElseThrow(() -> new ResourceNotFoundException("ProdChar not found with id " + prodCharId));
    }

    @DeleteMapping("/prodChar/{prodCharId}")
    public ResponseEntity<?> deleteProdChar(@PathVariable Long prodCharId) {
        return prodCharRepository.findById(prodCharId)
                .map(prodChar -> {
                    prodCharRepository.delete(prodChar);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("ProdChar not found with id " + prodCharId));
    }


}



