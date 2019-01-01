package com.keyfeni.adres.controller;

import com.keyfeni.common.exception.ResourceNotFoundException;
import com.keyfeni.adres.model.Mahalle;
import com.keyfeni.adres.repository.IlceRepository;
import com.keyfeni.adres.repository.MahalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MahalleController {

    @Autowired
    private MahalleRepository mahalleRepository;

    @Autowired
    private IlceRepository ilceRepository;

    @GetMapping("/ilce/{ilceId}/mahalle")
    public List<Mahalle> getMahallesByQuestionId(@PathVariable Long ilceId, @PathVariable Long mahalleId) {
        return mahalleRepository.findByIlceId(ilceId);
    }

    @PostMapping("/ilce/{ilceId}/mahalle")
    public Mahalle addMahalle(@PathVariable Long ilceId,
                              @Valid @RequestBody Mahalle mahalle) {
        return ilceRepository.findById(ilceId)
                .map(ilce -> {
                    mahalle.setSehir(ilce.getSehir());
                    mahalle.setIlce(ilce);
                    mahalle.setName(mahalle.getName());
                    return mahalleRepository.save(mahalle);
                }).orElseThrow(() -> new ResourceNotFoundException("Ilce not found with id " + ilceId));
    }

    @PutMapping("/ilce/{ilceId}/mahalle/{mahalleId}")
    public Mahalle updateMahalle(@PathVariable Long ilceId,
                                 @PathVariable Long mahalleId,
                                 @Valid @RequestBody Mahalle mahalleRequest) {
        if (!ilceRepository.existsById(ilceId)) {
            throw new ResourceNotFoundException("Ilce not found with id " + ilceId);
        }

        return mahalleRepository.findById(mahalleId)
                .map(mahalle -> {
                    mahalle.setName(mahalleRequest.getName());
                    return mahalleRepository.save(mahalle);
                }).orElseThrow(() -> new ResourceNotFoundException("Mahalle not found with id " + mahalleId));
    }

    @DeleteMapping("/ilce/{ilceId}/mahalle/{mahalleId}")
    public ResponseEntity<?> deleteMahalle(@PathVariable Long ilceId,
                                           @PathVariable Long mahalleId) {
        if (!ilceRepository.existsById(ilceId)) {
            throw new ResourceNotFoundException("Ilce not found with id " + ilceId);
        }

        return mahalleRepository.findById(mahalleId)
                .map(mahalle -> {
                    mahalleRepository.delete(mahalle);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Mahalle not found with id " + mahalleId));

    }
}
