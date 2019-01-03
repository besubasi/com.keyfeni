package com.keyfeni.restoran.controller;


import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.restoran.model.ProdOfrGrup;
import com.keyfeni.restoran.repository.ProdOfrGrupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProdOfrGrupController {

    @Autowired
    private ProdOfrGrupRepository prodOfrGrupRepository;


    @GetMapping("/prodOfrGrup")
    public Page<ProdOfrGrup> getProdOfrGrups(Pageable pageable) {
        return prodOfrGrupRepository.findAll(pageable);
    }


    @PostMapping("/prodOfrGrup")
    public ProdOfrGrup createProdOfrGrup(@Valid @RequestBody ProdOfrGrup prodOfrGrup) {
        return prodOfrGrupRepository.save(prodOfrGrup);
    }

    @PutMapping("/prodOfrGrup/{prodOfrGrupId}")
    public ProdOfrGrup updateProdOfrGrup(@PathVariable Long prodOfrGrupId,
                                         @Valid @RequestBody ProdOfrGrup prodOfrGrupRequest) {
        return prodOfrGrupRepository.findById(prodOfrGrupId)
                .map(prodOfrGrup -> {
                    prodOfrGrup.setName(prodOfrGrupRequest.getName());
                    return prodOfrGrupRepository.save(prodOfrGrup);
                }).orElseThrow(() -> new ResourceNotFoundException("ProdOfrGrup not found with id " + prodOfrGrupId));
    }

    @DeleteMapping("/prodOfrGrup/{prodOfrGrupId}")
    public ResponseEntity<?> deleteProdOfrGrup(@PathVariable Long prodOfrGrupId) {
        return prodOfrGrupRepository.findById(prodOfrGrupId)
                .map(prodOfrGrup -> {
                    prodOfrGrupRepository.delete(prodOfrGrup);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("ProdOfrGrup not found with id " + prodOfrGrupId));
    }


}


