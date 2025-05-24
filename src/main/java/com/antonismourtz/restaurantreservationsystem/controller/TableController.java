package com.antonismourtz.restaurantreservationsystem.controller;


import com.antonismourtz.restaurantreservationsystem.dtos.request.TableRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.TableResponseDTO;
import com.antonismourtz.restaurantreservationsystem.service.TableService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/restaurant")
public class TableController {

    private TableService tableService;

    @PostMapping("/admin")
    public ResponseEntity<TableResponseDTO> addTable(@RequestBody TableRequestDTO tableRequestDTO) {
        TableResponseDTO savedRestaurantTable = tableService.createTable(tableRequestDTO);
        return new ResponseEntity<>(savedRestaurantTable, HttpStatus.CREATED);
    }



}
