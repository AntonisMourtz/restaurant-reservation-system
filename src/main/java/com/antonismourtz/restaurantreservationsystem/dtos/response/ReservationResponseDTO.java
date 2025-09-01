package com.antonismourtz.restaurantreservationsystem.dtos.response;

import com.antonismourtz.restaurantreservationsystem.entity.RestaurantTable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReservationResponseDTO {

    @Schema(description = "Unique identifier of the reservation", example = "5")
    private Long reservationId;

    @Schema(description = "Day of the reservation", example = "TUESDAY")
    private DayOfWeek reservationDay;

    @Schema(description = "Time when the customer arrives at the restaurant", example = "12:00")
    private LocalTime reservationStartTime;

    @Schema(description = "Time when the customer leaves the restaurant", example = "14:00")
    private LocalTime reservationEndTime;

    @Schema(description = "Number of guests for the reservation", example = "4")
    private int numberOfGuests;

    @Schema(description = "Customer's full name", example = "Antonis Mourtzakis")
    private String customerName;

    @Schema(description = "Customer's email address", example = "antonis@example.com")
    private String customerEmail;

    @Schema(description = "Customer's phone number", example = "6912345678")
    private String customerPhone;

    @Schema(description = "Indicates whether the customer prefers indoor seating", example = "false")
    private boolean indoorPreference;

    @Schema(description = "The table that has been reserved", example = "Table 5")
    private String restaurantTable;

}
