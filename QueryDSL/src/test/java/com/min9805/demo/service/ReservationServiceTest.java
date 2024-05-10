package com.min9805.demo.service;

import com.min9805.demo.doamin.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Slf4j
class ReservationServiceTest {
    @Autowired
    private ReservationService reservationService;

    @Test
    @DisplayName("과거 예약 내역 조회")
    void findPastReservationsByClientId() {
        // given
        Long ClientId = 1L;

        // when
        List<Reservation> pastReservations = reservationService.findPastReservationsByClientId(ClientId);
        log.info("pastReservations: {}", pastReservations);
        pastReservations.stream().forEach(reservation -> log.info("reservation: {}", reservation.getName()));

        // then
        assertThat(pastReservations).isNotEmpty();
    }

    @Test
    @DisplayName("과거 예약 내역 조회(JPA before)")
    void findPastReservationsByClientIdJPABefore() {
        // given
        Long ClientId = 1L;

        // when
        List<Reservation> pastReservations = reservationService.findPastReservationsByClientIdJPABefore(ClientId);
        log.info("pastReservations: {}", pastReservations);
        pastReservations.stream().forEach(reservation -> log.info("reservation: {}", reservation.getName()));

        // then
        assertThat(pastReservations).isNotEmpty();
    }

    @Test
    @DisplayName("과거 예약 내역 조회(JPA Less then or equal to)")
    void findPastReservationsByClientIdJPALoe() {
        // given
        Long ClientId = 1L;

        // when
        List<Reservation> pastReservations = reservationService.findPastReservationsByClientIdJPALoe(ClientId);
        log.info("pastReservations: {}", pastReservations);
        pastReservations.stream().forEach(reservation -> log.info("reservation: {}", reservation.getName()));

        // then
        assertThat(pastReservations).isNotEmpty();
    }
}