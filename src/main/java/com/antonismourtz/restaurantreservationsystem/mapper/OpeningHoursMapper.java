package com.antonismourtz.restaurantreservationsystem.mapper;

import com.antonismourtz.restaurantreservationsystem.dtos.request.OpeningHoursRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.OpeningHoursResponseDTO;
import com.antonismourtz.restaurantreservationsystem.entity.OpeningHours;

public class OpeningHoursMapper {
    public static OpeningHours MapToOpeningHours(OpeningHoursRequestDTO openingHoursRequestDTO) {
        return new OpeningHours(
                openingHoursRequestDTO.getDayId(),
                openingHoursRequestDTO.getDayOfWeek(),
                openingHoursRequestDTO.getOpenTime(),
                openingHoursRequestDTO.getCloseTime(),
                openingHoursRequestDTO.isOpen()
        );
    }

    public static OpeningHoursResponseDTO MapToOpeningHoursResponseDTO(OpeningHours openingHours) {
        return new OpeningHoursResponseDTO(
                openingHours.getDayOfWeek(),
                openingHours.getOpenTime(),
                openingHours.getCloseTime(),
                openingHours.isOpen()
        );
    }
}
