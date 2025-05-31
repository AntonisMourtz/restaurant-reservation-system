package com.antonismourtz.restaurantreservationsystem.service;

import com.antonismourtz.restaurantreservationsystem.dtos.request.OpeningHoursRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.OpeningHoursResponseDTO;
import com.antonismourtz.restaurantreservationsystem.enums.DayOfWeek;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OpeningHoursService {
    OpeningHoursResponseDTO createOpeningHours(OpeningHoursRequestDTO openingHoursRequestDTO);

    List<OpeningHoursResponseDTO> getAllOpeningHours();

    OpeningHoursResponseDTO updateOpeningHoursByDay(DayOfWeek dayOfWeek, OpeningHoursRequestDTO openingHoursRequestDTO);

    void deleteAllOpeningHours();

    void checkOpeningHoursRequest(OpeningHoursRequestDTO openingHoursRequestDTO);

}
