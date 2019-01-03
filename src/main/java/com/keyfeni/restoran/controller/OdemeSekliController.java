package com.keyfeni.restoran.controller;

import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.restoran.model.OdemeSekli;
import com.keyfeni.restoran.repository.OdemeSekliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class OdemeSekliController {

    @Autowired
    private OdemeSekliRepository odemeSekliRepository;


    @GetMapping("/odemeSekli")
    public Page<OdemeSekli> getOdemeSeklis(Pageable pageable) {
        return odemeSekliRepository.findAll(pageable);
    }


    @PostMapping("/odemeSekli")
    public OdemeSekli createOdemeSekli(@Valid @RequestBody OdemeSekli odemeSekli) {
        return odemeSekliRepository.save(odemeSekli);
    }

    @PutMapping("/odemeSekli/{odemeSekliId}")
    public OdemeSekli updateOdemeSekli(@PathVariable Long odemeSekliId,
                                   @Valid @RequestBody OdemeSekli odemeSekliRequest) {
        return odemeSekliRepository.findById(odemeSekliId)
                .map(odemeSekli -> {
                    odemeSekli.setName(odemeSekliRequest.getName());
                    odemeSekli.setKod(odemeSekliRequest.getKod());
                    return odemeSekliRepository.save(odemeSekli);
                }).orElseThrow(() -> new ResourceNotFoundException("OdemeSekli not found with id " + odemeSekliId));
    }

    @DeleteMapping("/odemeSekli/{odemeSekliId}")
    public ResponseEntity<?> deleteOdemeSekli(@PathVariable Long odemeSekliId) {
        return odemeSekliRepository.findById(odemeSekliId)
                .map(odemeSekli -> {
                    odemeSekliRepository.delete(odemeSekli);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("OdemeSekli not found with id " + odemeSekliId));
    }



}

