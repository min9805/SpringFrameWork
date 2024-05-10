package com.min9805.demo.service;

import com.min9805.demo.doamin.Reservation;
import com.min9805.demo.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public List<Reservation> findPastReservationsByClientId(Long clientId) {
        log.info("pastReservationsByClientId");
        List<Reservation> pastReservationsByClientId = reservationRepository.findPastReservationsByClientId(clientId);
        log.info("pastReservationsByClientId.size(): {}", pastReservationsByClientId.size());
        pastReservationsByClientId.stream().forEach(reservation -> log.info("reservation: {}", reservation.getName()));
        return pastReservationsByClientId;
    }


    public List<Reservation> findPastReservationsByClientIdJPABefore(Long clientId) {

        return reservationRepository.findByClientIdAndReservatedAtBefore(clientId, LocalDateTime.now());
    }

    public List<Reservation> findPastReservationsByClientIdJPALoe(Long clientId) {
        return reservationRepository.findByClientIdAndReservatedAtLessThanEqual(clientId, LocalDateTime.now());
    }
}
