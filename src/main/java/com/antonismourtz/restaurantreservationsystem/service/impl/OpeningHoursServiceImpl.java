package com.antonismourtz.restaurantreservationsystem.service.impl;

import com.antonismourtz.restaurantreservationsystem.dtos.request.OpeningHoursRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.OpeningHoursResponseDTO;
import com.antonismourtz.restaurantreservationsystem.entity.OpeningHours;
import com.antonismourtz.restaurantreservationsystem.enums.DayOfWeek;
import com.antonismourtz.restaurantreservationsystem.exception.BusinessLogicException;
import com.antonismourtz.restaurantreservationsystem.exception.ResourceNotFoundException;
import com.antonismourtz.restaurantreservationsystem.mapper.OpeningHoursMapper;
import com.antonismourtz.restaurantreservationsystem.repository.OpeningHoursRepository;
import com.antonismourtz.restaurantreservationsystem.service.OpeningHoursService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class OpeningHoursServiceImpl implements OpeningHoursService {
    private OpeningHoursRepository openingHoursRepository;

    @Override
    public OpeningHoursResponseDTO createOpeningHours(OpeningHoursRequestDTO openingHoursRequestDTO) {
        // We check if the request data is valid
        checkOpeningHoursRequest(openingHoursRequestDTO);

        OpeningHours openingHours = OpeningHoursMapper.MapToOpeningHours(openingHoursRequestDTO);
        OpeningHours savedOpeningHours = openingHoursRepository.save(openingHours);
        return OpeningHoursMapper.MapToOpeningHoursResponseDTO(savedOpeningHours);
    }

    @Override
    public List<OpeningHoursResponseDTO> getAllOpeningHours() {
        List<OpeningHours> allOpeningHours = openingHoursRepository.findAll();

        return allOpeningHours.stream().map((openingHours) -> OpeningHoursMapper.MapToOpeningHoursResponseDTO(openingHours))
                .collect(Collectors.toList());
    }

    @Override
    public OpeningHoursResponseDTO updateOpeningHoursByDay(DayOfWeek dayOfWeek, OpeningHoursRequestDTO openingHoursRequestDTO) {

        checkOpeningHoursRequest(openingHoursRequestDTO);

        OpeningHours updatedOpeningHours = openingHoursRepository.findByDayOfWeek(dayOfWeek)
                .orElseThrow( () -> new ResourceNotFoundException("This day has not been registered yet. Please add it first."));

        updatedOpeningHours.setOpenTime(openingHoursRequestDTO.getOpenTime());
        updatedOpeningHours.setCloseTime(openingHoursRequestDTO.getCloseTime());
        updatedOpeningHours.setOpen(openingHoursRequestDTO.isOpen());

        OpeningHours savedOpeningHours = openingHoursRepository.save(updatedOpeningHours);

        return OpeningHoursMapper.MapToOpeningHoursResponseDTO(savedOpeningHours);
    }

    @Override
    public void deleteAllOpeningHours() {
        openingHoursRepository.deleteAll();
    }

    @Override
    public void checkOpeningHoursRequest(OpeningHoursRequestDTO openingHoursRequestDTO) {

        if (openingHoursRequestDTO.isOpen()==true &&
                (openingHoursRequestDTO.getOpenTime()==null || openingHoursRequestDTO.getCloseTime()==null)) {

            throw new BusinessLogicException("Opening hours are required if the restaurant is open.");
        }
        if (openingHoursRequestDTO.isOpen()==false &&
                (openingHoursRequestDTO.getOpenTime()!=null || openingHoursRequestDTO.getCloseTime()!=null)) {

            throw new BusinessLogicException("Please remove opening hours if the restaurant is closed.");
        }
        if(openingHoursRequestDTO.getOpenTime()!=null && openingHoursRequestDTO.getCloseTime()!=null &&
                (openingHoursRequestDTO.getCloseTime().isBefore(openingHoursRequestDTO.getOpenTime()))) {

            throw new BusinessLogicException("Opening time must be earlier than closing time.");
        }

    }
}
