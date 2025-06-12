package com.antonismourtz.restaurantreservationsystem.exception;

public class ActiveReservationsException extends RuntimeException {
    public ActiveReservationsException(String message) {
        super(message);
    }
}
