package com.min9805.demo.repository;

import com.min9805.demo.doamin.Reservation;

import java.util.List;

public interface ReservationCustomRepository {
    public List<Reservation> findPastReservationsByClientId(Long clientId);


}
