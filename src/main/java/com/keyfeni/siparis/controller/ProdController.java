package com.keyfeni.siparis.controller;


import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.siparis.model.Prod;
import com.keyfeni.siparis.repository.ProdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProdController {

    @Autowired
    private ProdRepository prodRepository;


    @GetMapping("/prod")
    public Page<Prod> getProds(Pageable pageable) {
        return prodRepository.findAll(pageable);
    }


    @PostMapping("/prod")
    public Prod createProd(@Valid @RequestBody Prod prod) {
        return prodRepository.save(prod);
    }

    @PutMapping("/prod/{prodId}")
    public Prod updateProd(@PathVariable Long prodId,
                           @Valid @RequestBody Prod prodRequest) {
        return prodRepository.findById(prodId)
                .map(prod -> {
                    return prodRepository.save(prod);
                }).orElseThrow(() -> new ResourceNotFoundException("Prod not found with id " + prodId));
    }

    @DeleteMapping("/prod/{prodId}")
    public ResponseEntity<?> deleteProd(@PathVariable Long prodId) {
        return prodRepository.findById(prodId)
                .map(prod -> {
                    prodRepository.delete(prod);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Prod not found with id " + prodId));
    }


}


