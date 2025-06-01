package com.antonismourtz.restaurantreservationsystem.dtos.request;

import com.antonismourtz.restaurantreservationsystem.enums.DayOfWeek;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpeningHoursRequestDTO {
    private Long dayId;
    private DayOfWeek dayOfWeek;
    private LocalTime openTime;
    private LocalTime closeTime;
    private boolean open;
}
