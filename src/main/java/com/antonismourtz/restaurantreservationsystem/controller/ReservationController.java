package com.antonismourtz.restaurantreservationsystem.controller;

import com.antonismourtz.restaurantreservationsystem.dtos.request.ReservationRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.ReservationResponseDTO;
import com.antonismourtz.restaurantreservationsystem.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Create a reservation", description = "Creates a new reservation for a customer. The system automatically assigns a table based on availability.")
    @ApiResponse(responseCode = "201", description = "Reservation created successfully")

    public ResponseEntity<ReservationResponseDTO> createReservation(@RequestBody ReservationRequestDTO reservationRequestDTO){
        ReservationResponseDTO savedReservation = reservationService.makeReservation(reservationRequestDTO);
        return new ResponseEntity<>(savedReservation, HttpStatus.CREATED);
    }

    @GetMapping("admin/reservations")
    @Operation(summary = "Get all reservations", description = "Returns the details of all reservations")
    @ApiResponse(responseCode = "200", description = "Reservations found successfully")

    public ResponseEntity<List<ReservationResponseDTO>> getAllReservations(){
        List<ReservationResponseDTO> allReservations = reservationService.getAllReservations();
        return new ResponseEntity<>(allReservations, HttpStatus.OK);
    }

    @DeleteMapping("admin/reservation/{id}")
    @Operation(summary = "Delete a reservation", description = "Deletes an existing reservation")
    @ApiResponse(responseCode = "200", description = "Reservation deleted successfully")

    public ResponseEntity<String> deleteReservation(@PathVariable("id") Long reservationId){
        reservationService.deleteReservation(reservationId);
        return ResponseEntity.ok("Reservation successfully deleted");
    }

    @DeleteMapping("admin/reservations")
    @Operation(summary = "Delete all reservations", description = "Deletes existing reservations")
    @ApiResponse(responseCode = "200", description = "Reservations deleted successfully")

    public ResponseEntity<String> deleteAllReservations(){
        reservationService.deleteAllReservations();
        return ResponseEntity.ok("All reservations successfully deleted");
    }

}
