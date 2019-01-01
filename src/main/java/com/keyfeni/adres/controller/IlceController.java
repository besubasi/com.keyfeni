package com.keyfeni.adres.controller;


import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.adres.model.Ilce;
import com.keyfeni.adres.repository.IlceRepository;
import com.keyfeni.adres.repository.SehirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class IlceController {

    @Autowired
    private IlceRepository ilceRepository;

    @Autowired
    private SehirRepository sehirRepository;

    @GetMapping("/sehir/{sehirId}/ilce")
    public List<Ilce> getIlcesByQuestionId(@PathVariable Long sehirId) {
        return ilceRepository.findBySehirId(sehirId);
    }

    @PostMapping("/sehir/{sehirId}/ilce")
    public Ilce addIlce(@PathVariable Long sehirId,
                            @Valid @RequestBody Ilce ilce) {
        return sehirRepository.findById(sehirId)
                .map(sehir -> {
                    ilce.setSehir(sehir);
                    ilce.setName(ilce.getName());
                    return ilceRepository.save(ilce);
                }).orElseThrow(() -> new ResourceNotFoundException("Sehir not found with id " + sehirId));
    }

    @PutMapping("/sehir/{sehirId}/ilce/{ilceId}")
    public Ilce updateIlce(@PathVariable Long sehirId,
                               @PathVariable Long ilceId,
                               @Valid @RequestBody Ilce ilceRequest) {
        if(!sehirRepository.existsById(sehirId)) {
            throw new ResourceNotFoundException("Question not found with id " + sehirId);
        }

        return ilceRepository.findById(ilceId)
                .map(ilce -> {
                    ilce.setName(ilceRequest.getName());
                    return ilceRepository.save(ilce);
                }).orElseThrow(() -> new ResourceNotFoundException("Ilce not found with id " + ilceId));
    }

    @DeleteMapping("/sehir/{sehirId}/ilce/{ilceId}")
    public ResponseEntity<?> deleteIlce(@PathVariable Long sehirId,
                                          @PathVariable Long ilceId) {
        if(!sehirRepository.existsById(sehirId)) {
            throw new ResourceNotFoundException("Sehir not found with id " + sehirId);
        }

        return ilceRepository.findById(ilceId)
                .map(ilce -> {
                    ilceRepository.delete(ilce);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Ilce not found with id " + ilceId));

    }
}
