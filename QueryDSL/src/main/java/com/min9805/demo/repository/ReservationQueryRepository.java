package com.min9805.demo.repository;

import com.min9805.demo.doamin.Reservation;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.min9805.demo.doamin.QReservation.reservation;

@Repository
@RequiredArgsConstructor
public class ReservationQueryRepository {
    private final JPAQueryFactory queryFactory;

    public List<Reservation> findPastReservations() {
        return queryFactory.selectFrom(reservation)
                .where(reservation.reservatedAt.before(
                        Expressions.dateTimeOperation(LocalDateTime.class,
                                Ops.DateTimeOps.CURRENT_TIMESTAMP)
                ))
                .fetch();
    }
}
