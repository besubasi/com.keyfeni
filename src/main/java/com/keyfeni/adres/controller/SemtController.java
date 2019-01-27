package com.keyfeni.adres.controller;


import com.keyfeni.adres.model.Semt;
import com.keyfeni.adres.repository.SemtRepository;
import com.keyfeni.common.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SemtController {

    @Autowired
    private SemtRepository semtRepository;


    @GetMapping("/semt")
    public Page<Semt> getsemt(Pageable pageable) {
        return semtRepository.findAll(pageable);
    }


    @PostMapping("/semt")
    public Semt createSemt(@Valid @RequestBody Semt semt) {
        return semtRepository.save(semt);
    }

    @PutMapping("/semt/{semtId}")
    public Semt updateSemt(@PathVariable Long semtId,
                             @Valid @RequestBody Semt semtRequest) {
        return semtRepository.findById(semtId)
                .map(semt -> {
                    semt.setName(semtRequest.getName());
                    return semtRepository.save(semt);
                }).orElseThrow(() -> new ResourceNotFoundException("Semt not found with id " + semtId));
    }

    @DeleteMapping("/semt/{semtId}")
    public ResponseEntity<?> deleteSemt(@PathVariable Long semtId) {
        return semtRepository.findById(semtId)
                .map(semt -> {
                    semtRepository.delete(semt);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Semt not found with id " + semtId));
    }



}

