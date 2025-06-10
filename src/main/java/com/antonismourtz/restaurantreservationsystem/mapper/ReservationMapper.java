package com.antonismourtz.restaurantreservationsystem.mapper;

import com.antonismourtz.restaurantreservationsystem.dtos.request.ReservationRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.ReservationResponseDTO;
import com.antonismourtz.restaurantreservationsystem.entity.Reservation;

public class ReservationMapper {
    public static ReservationResponseDTO mapReservationToReservationResponseDTO(Reservation reservation) {
        return new ReservationResponseDTO(
                reservation.getReservationId(),
                reservation.getReservationDay(),
                reservation.getReservationStartTime(),
                reservation.getReservationEndTime(),
                reservation.getNumberOfGuests(),
                reservation.getCustomerName(),
                reservation.getCustomerEmail(),
                reservation.getCustomerPhone(),
                reservation.isIndoorPreference(),
                // We want to return only the name of the table
                reservation.getRestaurantTable().getTableName()
                );
    }

    public static Reservation mapToReservation(ReservationRequestDTO reservationRequestDTO) {
        Reservation reservation = new Reservation();

        reservation.setReservationStartTime(reservationRequestDTO.getReservationStartTime());
        reservation.setReservationDay(reservationRequestDTO.getReservationDay());
        reservation.setReservationEndTime(reservationRequestDTO.getReservationEndTime());
        reservation.setCustomerEmail(reservationRequestDTO.getCustomerEmail());
        reservation.setCustomerPhone(reservationRequestDTO.getCustomerPhone());
        reservation.setCustomerName(reservationRequestDTO.getCustomerName());
        reservation.setNumberOfGuests(reservationRequestDTO.getNumberOfGuests());
        reservation.setIndoorPreference(reservationRequestDTO.isIndoorPreference());
        return reservation;
    }
}
