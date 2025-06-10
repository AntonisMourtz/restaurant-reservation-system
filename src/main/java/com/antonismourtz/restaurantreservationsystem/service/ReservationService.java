package com.antonismourtz.restaurantreservationsystem.service;

import com.antonismourtz.restaurantreservationsystem.dtos.request.ReservationRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.ReservationResponseDTO;

import java.util.List;

public interface ReservationService {
    ReservationResponseDTO makeReservation (ReservationRequestDTO reservationRequestDTO);
    boolean isReservationTimeValid(ReservationRequestDTO reservationRequestDTO);
    List<ReservationResponseDTO> getAllReservations();
    boolean checkDayOfReservation (ReservationRequestDTO reservationRequestDTO);
    boolean isReservationWithinOpeningHours(ReservationRequestDTO reservationRequestDTO);
}
