package com.antonismourtz.restaurantreservationsystem.exception;

public class ReservationNotPossibleException extends RuntimeException {
    public ReservationNotPossibleException(String message) {
        super(message);
    }
}
