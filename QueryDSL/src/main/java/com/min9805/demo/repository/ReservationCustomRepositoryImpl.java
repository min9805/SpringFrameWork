package com.min9805.demo.repository;

import com.min9805.demo.doamin.Reservation;
import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DateTemplate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringTemplate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


import static com.min9805.demo.doamin.QReservation.reservation;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ReservationCustomRepositoryImpl implements ReservationCustomRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Reservation> findPastReservationsByClientId(Long clientId) {
//            String dateFormat = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//            DateTemplate<String> formattedDate = Expressions.dateTemplate(String.class, "datetime({0})", reservation.reservatedAt, ConstantImpl.create("%Y-%m-%d %H:%i:%s"));
////        StringTemplate formattedDate = Expressions.stringTemplate("datetime({0})", reservation.reservatedAt);
//        log.info("formattedDate: {}", formattedDate);
//
//        return queryFactory
//                    .selectFrom(reservation)
//                    .where(formattedDate.goe(dateFormat))
//                    .fetch();
        return queryFactory
                .selectFrom(reservation)
                .where(reservation.reservatedAt.after(
                        Expressions.dateTimeOperation(
                                LocalDateTime.class, Ops.DateTimeOps.CURRENT_TIMESTAMP
                        )))
                .fetch();
    }

}
