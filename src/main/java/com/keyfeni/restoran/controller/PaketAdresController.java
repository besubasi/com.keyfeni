package com.keyfeni.restoran.controller;

import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.restoran.model.PaketAdres;
import com.keyfeni.restoran.repository.PaketAdresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PaketAdresController {

    @Autowired
    private PaketAdresRepository paketAdresRepository;

    @GetMapping("/paketAdres")
    public Page<PaketAdres> getPaketAdres(Pageable pageable) {
        return paketAdresRepository.findAll(pageable);
    }


    @PostMapping("/paketAdres")
    public PaketAdres createPaketAdres(@Valid @RequestBody PaketAdres paketAdres) {
        return paketAdresRepository.save(paketAdres);
    }

    @PutMapping("/paketAdres/{paketAdresId}")
    public PaketAdres updatePaketAdres(@PathVariable Long paketAdresId,
                                       @Valid @RequestBody PaketAdres paketAdresRequest) {
        return paketAdresRepository.findById(paketAdresId)
                .map(paketAdres -> {
                    paketAdres.setMinimum(paketAdresRequest.getMinimum());
                    return paketAdresRepository.save(paketAdres);
                }).orElseThrow(() -> new ResourceNotFoundException("PaketAdres not found with id " + paketAdresId));
    }

    @DeleteMapping("/paketAdres/{paketAdresId}")
    public ResponseEntity<?> deletePaketAdres(@PathVariable Long paketAdresId) {
        return paketAdresRepository.findById(paketAdresId)
                .map(paketAdres -> {
                    paketAdresRepository.delete(paketAdres);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("PaketAdres not found with id " + paketAdresId));
    }


}
