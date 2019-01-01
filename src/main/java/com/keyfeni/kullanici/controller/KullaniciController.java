package com.keyfeni.kullanici.controller;

import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.kullanici.model.Kullanici;
import com.keyfeni.kullanici.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class KullaniciController {

    @Autowired
    private KullaniciRepository kullaniciRepository;


    @GetMapping("/kullanici")
    public Page<Kullanici> getkullanici(Pageable pageable) {
        return kullaniciRepository.findAll(pageable);
    }


    @PostMapping("/kullanici")
    public Kullanici createKullanici(@Valid @RequestBody Kullanici kullanici) {
        return kullaniciRepository.save(kullanici);
    }

    @PutMapping("/kullanici/{kullaniciId}")
    public Kullanici updateKullanici(@PathVariable Long kullaniciId,
                                @Valid @RequestBody Kullanici kullaniciRequest) {
        return kullaniciRepository.findById(kullaniciId)
                .map(kullanici -> {
                    kullanici.setName(kullaniciRequest.getName());
                    kullanici.setEmail(kullaniciRequest.getEmail());
                    kullanici.setPassword(kullaniciRequest.getPassword());
                    return kullaniciRepository.save(kullanici);
                }).orElseThrow(() -> new ResourceNotFoundException("Kullanici not found with id " + kullaniciId));
    }

    @DeleteMapping("/kullanici/{kullaniciId}")
    public ResponseEntity<?> deleteKullanici(@PathVariable Long kullaniciId) {
        return kullaniciRepository.findById(kullaniciId)
                .map(kullanici -> {
                    kullaniciRepository.delete(kullanici);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Kullanici not found with id " + kullaniciId));
    }

}

