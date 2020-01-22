package com.tucanoo.springbootlil.business.service;

import com.tucanoo.springbootlil.business.domain.RoomReservation;
import com.tucanoo.springbootlil.data.entity.Guest;
import com.tucanoo.springbootlil.data.entity.Reservation;
import com.tucanoo.springbootlil.data.entity.Room;
import com.tucanoo.springbootlil.data.repository.GuestRepository;
import com.tucanoo.springbootlil.data.repository.ReservationRepository;
import com.tucanoo.springbootlil.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservations (Date date) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap();
        rooms.forEach(room -> {
            RoomReservation reservation = new RoomReservation();
            reservation.setRoomId(room.getRoomId());
            reservation.setRoomName(room.getRoomName());
            reservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getRoomId(), reservation);
        });

        Iterable<Reservation> reservations = this.reservationRepository
                .findReservationByReservationDate(new java.sql.Date(date.getTime()));

        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setGuestId(guest.getGuestId());
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
        });

        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long id: roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(id));
        }

        return roomReservations;
    }

    public List<Guest> getGuests(){
        List<Guest> sortedGuests = new ArrayList<>();
        Iterable<Guest> allGuests = guestRepository.findAll();
        allGuests.forEach(guest -> {
            sortedGuests.add(guest);
        });
        sortedGuests.sort(new Comparator<Guest>() {
            @Override
            public int compare(Guest o1, Guest o2) {
                return o1.getLastName().compareToIgnoreCase(o2.getLastName());
            }
        });
        return sortedGuests;
    }
}
