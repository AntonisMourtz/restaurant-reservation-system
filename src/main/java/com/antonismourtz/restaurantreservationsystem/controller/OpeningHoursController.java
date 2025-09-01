package com.antonismourtz.restaurantreservationsystem.controller;

import com.antonismourtz.restaurantreservationsystem.dtos.request.OpeningHoursRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.OpeningHoursResponseDTO;
import com.antonismourtz.restaurantreservationsystem.service.OpeningHoursService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.DayOfWeek;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/restaurant")
public class OpeningHoursController {

    private OpeningHoursService openingHoursService;

    // Create opening_hours (admin only)
    @PostMapping("admin/opening_hours")
    @Operation(summary = "Add opening hours", description = "Adds new opening hours for the restaurant and returns the created schedule")
    @ApiResponse(responseCode = "201", description = "Opening hours added successfully")

    public ResponseEntity<OpeningHoursResponseDTO> createOpeningHours(@RequestBody OpeningHoursRequestDTO openingHoursRequestDTO) {
        OpeningHoursResponseDTO savedOpeningHours = openingHoursService.createOpeningHours(openingHoursRequestDTO);
        return new ResponseEntity<>(savedOpeningHours, HttpStatus.CREATED);
    }

    // View opening_hours (admin/user)
    @GetMapping("opening_hours")
    @Operation(summary = "Get opening hours", description = "Returns the current opening hours of the restaurant")
    @ApiResponse(responseCode = "200", description = "Opening hours found successfully")

    public ResponseEntity<List<OpeningHoursResponseDTO>> getAllOpeningHours() {
       List<OpeningHoursResponseDTO> allOpeningHours = openingHoursService.getAllOpeningHours();
       return  ResponseEntity.ok(allOpeningHours);
    }

    // Update opening_hours (admin only)
    @PutMapping("admin/opening_hours/{dayOfWeek}")
    @Operation(summary = "Update opening hours", description = "Updates existing opening hours and returns the updated schedule")
    @ApiResponse(responseCode = "200", description = "Opening hours updated successfully")

    public ResponseEntity<OpeningHoursResponseDTO> updateOpeningHoursByDay(@PathVariable DayOfWeek dayOfWeek, @RequestBody OpeningHoursRequestDTO openingHoursRequestDTO) {
        OpeningHoursResponseDTO updatedOpeningHours = openingHoursService.updateOpeningHoursByDay(dayOfWeek, openingHoursRequestDTO);
        return ResponseEntity.ok(updatedOpeningHours);
    }

    // Delete opening_hours (admin only)
    @DeleteMapping("admin/opening_hours")
    @Operation(summary = "Delete opening hours", description = "Deletes existing opening hours for the restaurant")
    @ApiResponse(responseCode = "200", description = "Opening hours deleted successfully")

    public ResponseEntity<String> deleteAllOpeningHours() {
        openingHoursService.deleteAllOpeningHours();
        return ResponseEntity.ok("All opening hours have been deleted");
    }
}
