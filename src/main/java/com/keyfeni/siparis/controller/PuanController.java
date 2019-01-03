package com.keyfeni.siparis.controller;


import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.siparis.model.Puan;
import com.keyfeni.siparis.repository.PuanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PuanController {

    @Autowired
    private PuanRepository puanRepository;


    @GetMapping("/puan")
    public Page<Puan> getPuans(Pageable pageable) {
        return puanRepository.findAll(pageable);
    }


    @PostMapping("/puan")
    public Puan createPuan(@Valid @RequestBody Puan puan) {
        return puanRepository.save(puan);
    }

    @PutMapping("/puan/{puanId}")
    public Puan updatePuan(@PathVariable Long puanId,
                           @Valid @RequestBody Puan puanRequest) {
        return puanRepository.findById(puanId)
                .map(puan -> {
                    puan.setPuanTuru(puanRequest.getPuanTuru());
                    puan.setPuan(puanRequest.getPuan());
                    puan.setYorum(puanRequest.getYorum());
                    return puanRepository.save(puan);
                }).orElseThrow(() -> new ResourceNotFoundException("Puan not found with id " + puanId));
    }

    @DeleteMapping("/puan/{puanId}")
    public ResponseEntity<?> deletePuan(@PathVariable Long puanId) {
        return puanRepository.findById(puanId)
                .map(puan -> {
                    puanRepository.delete(puan);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Puan not found with id " + puanId));
    }


}


