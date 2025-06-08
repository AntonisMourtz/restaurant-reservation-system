package com.antonismourtz.restaurantreservationsystem.dtos.response;

import com.antonismourtz.restaurantreservationsystem.entity.RestaurantTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReservationResponseDTO {

    private Long reservationId;
    private DayOfWeek reservationDay;
    private LocalTime reservationStartTime;
    private LocalTime reservationEndTime;
    private int numberOfGuests;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private boolean indoorPreference;
    private String restaurantTable;

}
