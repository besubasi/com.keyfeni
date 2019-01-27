package com.keyfeni.restoran.controller;


import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.restoran.model.RestoranOdemeSekli;
import com.keyfeni.restoran.repository.RestoranOdemeSekliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RestoranOdemeSekliController {

    @Autowired
    private RestoranOdemeSekliRepository restoranOdemeSekliRepository;


    @GetMapping("/restoranOdemeSekli")
    public Page<RestoranOdemeSekli> getRestoranOdemeSeklis(Pageable pageable) {
        return restoranOdemeSekliRepository.findAll(pageable);
    }


    @PostMapping("/restoranOdemeSekli")
    public RestoranOdemeSekli createRestoranOdemeSekli(@Valid @RequestBody RestoranOdemeSekli restoranOdemeSekli) {
        return restoranOdemeSekliRepository.save(restoranOdemeSekli);
    }

    @PutMapping("/restoranOdemeSekli/{restoranOdemeSekliId}")
    public RestoranOdemeSekli updateRestoranOdemeSekli(@PathVariable Long restoranOdemeSekliId,
                                                       @Valid @RequestBody RestoranOdemeSekli restoranOdemeSekliRequest) {
        return restoranOdemeSekliRepository.findById(restoranOdemeSekliId)
                .map(restoranOdemeSekli -> {
                    restoranOdemeSekli.setOdemeSekli(restoranOdemeSekliRequest.getOdemeSekli());
                    return restoranOdemeSekliRepository.save(restoranOdemeSekli);
                }).orElseThrow(() -> new ResourceNotFoundException("RestoranOdemeSekli not found with id " + restoranOdemeSekliId));
    }

    @DeleteMapping("/restoranOdemeSekli/{restoranOdemeSekliId}")
    public ResponseEntity<?> deleteRestoranOdemeSekli(@PathVariable Long restoranOdemeSekliId) {
        return restoranOdemeSekliRepository.findById(restoranOdemeSekliId)
                .map(restoranOdemeSekli -> {
                    restoranOdemeSekliRepository.delete(restoranOdemeSekli);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("RestoranOdemeSekli not found with id " + restoranOdemeSekliId));
    }


}

