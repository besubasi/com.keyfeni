package com.keyfeni.restoran.controller;

import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.restoran.model.RestoranMahalle;
import com.keyfeni.restoran.repository.RestoranMahalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RestoranMahalleController {

    @Autowired
    private RestoranMahalleRepository restoranMahalleRepository;

    @GetMapping("/restoranMahalle")
    public Page<RestoranMahalle> getRestoranMahalle(Pageable pageable) {
        return restoranMahalleRepository.findAll(pageable);
    }


    @PostMapping("/restoranMahalle")
    public RestoranMahalle createRestoranMahalle(@Valid @RequestBody RestoranMahalle restoranMahalle) {
        return restoranMahalleRepository.save(restoranMahalle);
    }

    @PutMapping("/restoranMahalle/{restoranMahalleId}")
    public RestoranMahalle updateRestoranMahalle(@PathVariable Long restoranMahalleId,
                                            @Valid @RequestBody RestoranMahalle restoranMahalleRequest) {
        return restoranMahalleRepository.findById(restoranMahalleId)
                .map(restoranMahalle -> {
                    restoranMahalle.setMinimum(restoranMahalleRequest.getMinimum());
                    return restoranMahalleRepository.save(restoranMahalle);
                }).orElseThrow(() -> new ResourceNotFoundException("RestoranMahalle not found with id " + restoranMahalleId));
    }

    @DeleteMapping("/restoranMahalle/{restoranMahalleId}")
    public ResponseEntity<?> deleteRestoranMahalle(@PathVariable Long restoranMahalleId) {
        return restoranMahalleRepository.findById(restoranMahalleId)
                .map(restoranMahalle -> {
                    restoranMahalleRepository.delete(restoranMahalle);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("RestoranMahalle not found with id " + restoranMahalleId));
    }


}
