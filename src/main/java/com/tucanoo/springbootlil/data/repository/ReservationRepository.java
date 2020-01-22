package com.tucanoo.springbootlil.data.repository;

import com.tucanoo.springbootlil.data.entity.Reservation;
import com.tucanoo.springbootlil.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Iterable<Reservation> findReservationByReservationDate(Date date);
}
