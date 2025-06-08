package com.antonismourtz.restaurantreservationsystem.controller;

import com.antonismourtz.restaurantreservationsystem.dtos.request.ReservationRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.ReservationResponseDTO;
import com.antonismourtz.restaurantreservationsystem.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/restaurant")
public class ReservationController {

    private ReservationService reservationService;

    @PostMapping("reservation")
    public ResponseEntity<ReservationResponseDTO> createReservation(@RequestBody ReservationRequestDTO reservationRequestDTO){
        ReservationResponseDTO savedReservation = reservationService.makeReservation(reservationRequestDTO);
        return new ResponseEntity<>(savedReservation, HttpStatus.CREATED);
    }
    @GetMapping("admin/reservation")
    public ResponseEntity<List<ReservationResponseDTO>> getAllReservations(){
        List<ReservationResponseDTO> allReservations = reservationService.getAllReservations();
        return new ResponseEntity<>(allReservations, HttpStatus.OK);
    }
}
