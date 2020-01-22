package com.tucanoo.springbootlil;

import com.tucanoo.springbootlil.data.entity.Guest;
import com.tucanoo.springbootlil.data.entity.Reservation;
import com.tucanoo.springbootlil.data.entity.Room;
import com.tucanoo.springbootlil.data.repository.GuestRepository;
import com.tucanoo.springbootlil.data.repository.ReservationRepository;
import com.tucanoo.springbootlil.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringbootlilApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootlilApplication.class, args);
    }

    @RestController
    @RequestMapping("/rooms")
    public class RoomController {
        @Autowired
        private RoomRepository roomRepository;

        @GetMapping
        public Iterable<Room> getRooms(){
            return this.roomRepository.findAll();
        }
    }

    @RestController
    @RequestMapping("/guests")
    public class GuestController {
        @Autowired
        private GuestRepository guestRepository;

        @GetMapping
        public Iterable<Guest> getGuests(){
            return this.guestRepository.findAll();
        }
    }

    @RestController
    @RequestMapping("/reservations")
    public class ReservationController {
        @Autowired
        private ReservationRepository reservationRepository;

        @GetMapping
        public Iterable<Reservation> getReservations(){
            return this.reservationRepository.findAll();
        }
    }


}
