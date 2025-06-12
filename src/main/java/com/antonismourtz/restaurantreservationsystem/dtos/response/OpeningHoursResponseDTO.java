package com.antonismourtz.restaurantreservationsystem.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpeningHoursResponseDTO {
    private DayOfWeek dayOfWeek;
    private LocalTime openTime;
    private LocalTime closeTime;
    private boolean open;
}
