package com.keyfeni.kullanici.controller;

import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.kullanici.model.KullaniciAdres;
import com.keyfeni.kullanici.repository.KullaniciAdresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class KullaniciAdresController {

    @Autowired
    private KullaniciAdresRepository kullaniciAdresRepository;


    @GetMapping("/kullaniciAdres")
    public Page<KullaniciAdres> getKullaniciAdres(Pageable pageable) {
        return kullaniciAdresRepository.findAll(pageable);
    }


    @PostMapping("/kullaniciAdres")
    public KullaniciAdres createKullaniciAdres(@Valid @RequestBody KullaniciAdres kullaniciAdres) {
        return kullaniciAdresRepository.save(kullaniciAdres);
    }

    @PutMapping("/kullaniciAdres/{kullaniciAdresId}")
    public KullaniciAdres updateKullaniciAdres(@PathVariable Long kullaniciAdresId,
                                          @Valid @RequestBody KullaniciAdres kullaniciAdresRequest) {
        return kullaniciAdresRepository.findById(kullaniciAdresId)
                .map(kullaniciAdres -> {
                    kullaniciAdres.setAdres(kullaniciAdresRequest.getAdres());
                    kullaniciAdres.setName(kullaniciAdresRequest.getName());
                    return kullaniciAdresRepository.save(kullaniciAdres);
                }).orElseThrow(() -> new ResourceNotFoundException("KullaniciAdres not found with id " + kullaniciAdresId));
    }

    @DeleteMapping("/kullaniciAdres/{kullaniciAdresId}")
    public ResponseEntity<?> deleteKullaniciAdres(@PathVariable Long kullaniciAdresId) {
        return kullaniciAdresRepository.findById(kullaniciAdresId)
                .map(kullaniciAdres -> {
                    kullaniciAdresRepository.delete(kullaniciAdres);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("KullaniciAdres not found with id " + kullaniciAdresId));
    }


}


