package com.keyfeni.adres.controller;


import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.adres.model.Sehir;
import com.keyfeni.adres.repository.SehirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SehirController {

    @Autowired
    private SehirRepository sehirRepository;


    @GetMapping("/sehir")
    public Page<Sehir> getsehir(Pageable pageable) {
        return sehirRepository.findAll(pageable);
    }


    @PostMapping("/sehir")
    public Sehir createSehir(@Valid @RequestBody Sehir sehir) {
        return sehirRepository.save(sehir);
    }

    @PutMapping("/sehir/{sehirId}")
    public Sehir updateSehir(@PathVariable Long sehirId,
                               @Valid @RequestBody Sehir sehirRequest) {
        return sehirRepository.findById(sehirId)
                .map(sehir -> {
                    sehir.setName(sehirRequest.getName());
                    return sehirRepository.save(sehir);
                }).orElseThrow(() -> new ResourceNotFoundException("Sehir not found with id " + sehirId));
    }

    @DeleteMapping("/sehir/{sehirId}")
    public ResponseEntity<?> deleteSehir(@PathVariable Long sehirId) {
        return sehirRepository.findById(sehirId)
                .map(sehir -> {
                    sehirRepository.delete(sehir);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Sehir not found with id " + sehirId));
    }



}

