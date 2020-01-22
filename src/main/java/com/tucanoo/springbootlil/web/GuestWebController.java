package com.tucanoo.springbootlil.web;

import com.tucanoo.springbootlil.business.domain.RoomReservation;
import com.tucanoo.springbootlil.business.service.ReservationService;
import com.tucanoo.springbootlil.data.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestWebController {
    private final ReservationService reservationService;

    @Autowired
    public GuestWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getGuests(Model model) {

        List<Guest> guests = this.reservationService.getGuests();
        model.addAttribute("guests", guests);

        return "guests";
    }
}
