package com.antonismourtz.restaurantreservationsystem.controller;


import com.antonismourtz.restaurantreservationsystem.dtos.request.TableRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.TableResponseDTO;
import com.antonismourtz.restaurantreservationsystem.service.TableService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/restaurant")
public class TableController {

    private TableService tableService;

    // Create a table
    @PostMapping("/admin/table")
    public ResponseEntity<TableResponseDTO> addTable(@RequestBody TableRequestDTO tableRequestDTO) {
        TableResponseDTO savedRestaurantTable = tableService.createTable(tableRequestDTO);
        return new ResponseEntity<>(savedRestaurantTable, HttpStatus.CREATED);
    }

    // View table with ID
    @GetMapping("/admin/table/{id}")
    public ResponseEntity<TableResponseDTO> getTableById(@PathVariable("id") long tableId) {
        TableResponseDTO tableResponseDTO = tableService.getTableById(tableId);
        return ResponseEntity.ok(tableResponseDTO);
    }

    // View all tables
    @GetMapping("/admin/tables")
    public ResponseEntity<List<TableResponseDTO>> getAllTables() {
        List<TableResponseDTO> allTables = tableService.getAllTables();
        return ResponseEntity.ok(allTables);
    }

    // Update a table
    @PutMapping("/admin/table/{id}")
    public ResponseEntity<TableResponseDTO> updateTable(@PathVariable("id") long tableId, @RequestBody TableRequestDTO tableRequestDTO) {
        TableResponseDTO updatedTable = tableService.updateTable(tableId, tableRequestDTO);
        return ResponseEntity.ok(updatedTable);
    }

    // Delete a table
    @DeleteMapping("/admin/table/{id}")
    public ResponseEntity<String> deleteTable(@PathVariable("id") long tableId) {
        tableService.deleteTable(tableId);
        return ResponseEntity.ok("Table with ID: " +tableId+ " deleted");
    }



}
