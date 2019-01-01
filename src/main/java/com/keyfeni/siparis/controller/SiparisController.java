package com.keyfeni.siparis.controller;


import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.siparis.model.Siparis;
import com.keyfeni.siparis.repository.SiparisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SiparisController {

    @Autowired
    private SiparisRepository siparisRepository;


    @GetMapping("/siparis")
    public Page<Siparis> getSipariss(Pageable pageable) {
        return siparisRepository.findAll(pageable);
    }


    @PostMapping("/siparis")
    public Siparis createSiparis(@Valid @RequestBody Siparis siparis) {
        return siparisRepository.save(siparis);
    }

    @PutMapping("/siparis/{siparisId}")
    public Siparis updateSiparis(@PathVariable Long siparisId,
                               @Valid @RequestBody Siparis siparisRequest) {
        return siparisRepository.findById(siparisId)
                .map(siparis -> {
                    siparis.setKullaniciAdresId(siparisRequest.getKullaniciAdresId());
                    return siparisRepository.save(siparis);
                }).orElseThrow(() -> new ResourceNotFoundException("Siparis not found with id " + siparisId));
    }

    @DeleteMapping("/siparis/{siparisId}")
    public ResponseEntity<?> deleteSiparis(@PathVariable Long siparisId) {
        return siparisRepository.findById(siparisId)
                .map(siparis -> {
                    siparisRepository.delete(siparis);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Siparis not found with id " + siparisId));
    }



}

