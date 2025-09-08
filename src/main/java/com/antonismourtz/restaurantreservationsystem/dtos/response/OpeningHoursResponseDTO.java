package com.antonismourtz.restaurantreservationsystem.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpeningHoursResponseDTO {

    @Schema(description = "Day of the week", example = "FRIDAY")
    private DayOfWeek dayOfWeek;

    @Schema(description = "Opening time of the restaurant", example = "10:00")
    private LocalTime openTime;

    @Schema(description = "Closing time of the restaurant", example = "21:30")
    private LocalTime closeTime;

    @Schema(description = "Indicates whether the restaurant is open", example = "true")
    private boolean open;
}
