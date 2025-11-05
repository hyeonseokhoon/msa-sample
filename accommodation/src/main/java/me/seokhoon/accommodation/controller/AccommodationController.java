package me.seokhoon.accommodation.controller;

import lombok.RequiredArgsConstructor;
import me.seokhoon.accommodation.domain.Accommodation;
import me.seokhoon.accommodation.service.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accommodations")
@RequiredArgsConstructor
public class AccommodationController {
    private final AccommodationService service;

    @PostMapping
    public ResponseEntity<Accommodation> create(@RequestBody Accommodation a) {
        return ResponseEntity.ok(service.save(a));
    }

    @GetMapping
    public ResponseEntity<List<Accommodation>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> get(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}