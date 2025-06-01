package com.antonismourtz.restaurantreservationsystem.controller;

import com.antonismourtz.restaurantreservationsystem.dtos.request.OpeningHoursRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.OpeningHoursResponseDTO;
import com.antonismourtz.restaurantreservationsystem.enums.DayOfWeek;
import com.antonismourtz.restaurantreservationsystem.exception.ResourceNotFoundException;
import com.antonismourtz.restaurantreservationsystem.service.OpeningHoursService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/restaurant")
public class OpeningHoursController {

    private OpeningHoursService openingHoursService;

    // Create opening_hours (admin only)
    @PostMapping("admin/opening_hours")
    public ResponseEntity<OpeningHoursResponseDTO> createOpeningHours(@RequestBody OpeningHoursRequestDTO openingHoursRequestDTO) {
        OpeningHoursResponseDTO savedOpeningHours = openingHoursService.createOpeningHours(openingHoursRequestDTO);
        return new ResponseEntity<>(savedOpeningHours, HttpStatus.CREATED);
    }

    // View opening_hours (admin/user)
    @GetMapping("opening_hours")
    public ResponseEntity<List<OpeningHoursResponseDTO>> getAllOpeningHours() {
       List<OpeningHoursResponseDTO> allOpeningHours = openingHoursService.getAllOpeningHours();
       return  ResponseEntity.ok(allOpeningHours);
    }

    // Update opening_hours (admin only)
    @PutMapping("admin/opening_hours/{dayOfWeek}")
    public ResponseEntity<OpeningHoursResponseDTO> updateOpeningHoursByDay(@PathVariable DayOfWeek dayOfWeek, @RequestBody OpeningHoursRequestDTO openingHoursRequestDTO) {
        OpeningHoursResponseDTO updatedOpeningHours = openingHoursService.updateOpeningHoursByDay(dayOfWeek, openingHoursRequestDTO);
        return ResponseEntity.ok(updatedOpeningHours);
    }

    // Delete opening_hours (admin only)
    @DeleteMapping("admin/opening_hours")
    public ResponseEntity<String> deleteAllOpeningHours() {
        openingHoursService.deleteAllOpeningHours();
        return ResponseEntity.ok("All opening hours have been deleted");
    }

}
