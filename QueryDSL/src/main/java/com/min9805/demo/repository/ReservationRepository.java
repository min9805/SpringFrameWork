package com.min9805.demo.repository;

import com.min9805.demo.doamin.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long>, ReservationCustomRepository {
    List<Reservation> findByClientIdAndReservatedAtBefore(Long client_id, LocalDateTime reservatedAt);
    List<Reservation> findByClientIdAndReservatedAtLessThanEqual(Long client_id, LocalDateTime reservatedAt);
}
