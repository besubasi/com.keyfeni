package com.keyfeni.restoran.controller;


import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.restoran.model.Restoran;
import com.keyfeni.restoran.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RestoranController {
    
    @Autowired
    private RestoranRepository restoranRepository;


    @GetMapping("/restoran")
    public Page<Restoran> getRestorans(Pageable pageable) {
        return restoranRepository.findAll(pageable);
    }


    @PostMapping("/restoran")
    public Restoran createRestoran(@Valid @RequestBody Restoran restoran) {
        return restoranRepository.save(restoran);
    }

    @PutMapping("/restoran/{restoranId}")
    public Restoran updateRestoran(@PathVariable Long restoranId,
                                 @Valid @RequestBody Restoran restoranRequest) {
        return restoranRepository.findById(restoranId)
                .map(restoran -> {
                    restoran.setName(restoranRequest.getName());
                    restoran.setEmail(restoranRequest.getEmail());
                    restoran.setPassword(restoranRequest.getPassword());
                    return restoranRepository.save(restoran);
                }).orElseThrow(() -> new ResourceNotFoundException("Restoran not found with id " + restoranId));
    }

    @DeleteMapping("/restoran/{restoranId}")
    public ResponseEntity<?> deleteRestoran(@PathVariable Long restoranId) {
        return restoranRepository.findById(restoranId)
                .map(restoran -> {
                    restoranRepository.delete(restoran);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Restoran not found with id " + restoranId));
    }
    
    
    
}

