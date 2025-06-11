package com.antonismourtz.restaurantreservationsystem.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDTO {

    private LocalTime reservationStartTime;
    private DayOfWeek reservationDay;
    private LocalTime reservationEndTime;
    private int numberOfGuests;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private boolean indoorPreference;

}
