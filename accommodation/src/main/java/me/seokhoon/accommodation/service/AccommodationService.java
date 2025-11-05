package me.seokhoon.accommodation.service;

import lombok.RequiredArgsConstructor;
import me.seokhoon.accommodation.domain.Accommodation;
import me.seokhoon.accommodation.repository.AccommodationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccommodationService {
    private final AccommodationRepository repository;

    public Accommodation save(Accommodation accommodation) {
        return repository.save(accommodation);
    }

    public List<Accommodation> findAll() {
        return repository.findAll();
    }

    public Optional<Accommodation> findById(Long id) {
        return repository.findById(id);
    }
}
