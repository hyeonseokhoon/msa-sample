package me.seokhoon.reservation.service;

import lombok.RequiredArgsConstructor;
import me.seokhoon.reservation.domain.Reservation;
import me.seokhoon.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository repository;

    public Reservation create(Reservation reservation) {
        reservation.confirm();
        return repository.save(reservation);
    }

    public List<Reservation> findByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public void cancel(Long id) {
        repository.findById(id).ifPresent(r -> {
            r.cancel();
            repository.save(r);
        });
    }
}
