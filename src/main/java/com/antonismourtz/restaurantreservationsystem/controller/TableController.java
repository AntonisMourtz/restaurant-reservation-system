package com.antonismourtz.restaurantreservationsystem.controller;

import com.antonismourtz.restaurantreservationsystem.dtos.request.TableRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.TableResponseDTO;
import com.antonismourtz.restaurantreservationsystem.service.TableService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Add a new table", description = "Creates a new table and returns the created table")
    @ApiResponse(responseCode = "201", description = "Table crated successfully")

    public ResponseEntity<TableResponseDTO> addTable(@RequestBody TableRequestDTO tableRequestDTO) {
        TableResponseDTO savedRestaurantTable = tableService.createTable(tableRequestDTO);
        return new ResponseEntity<>(savedRestaurantTable, HttpStatus.CREATED);
    }

    // View table with ID
    @GetMapping("/admin/table/{id}")
    @Operation(summary = "Get table by ID", description = "Returns the details of a table by its ID")
    @ApiResponse(responseCode = "200", description = "Table found successfully")

    public ResponseEntity<TableResponseDTO> getTableById(@PathVariable("id") long tableId) {
        TableResponseDTO tableResponseDTO = tableService.getTableById(tableId);
        return ResponseEntity.ok(tableResponseDTO);
    }

    // View all tables
    @GetMapping("/admin/tables")
    @Operation(summary = "Get all tables", description = "Returns the details of all tables")
    @ApiResponse(responseCode = "200", description = "Tables found successfully")

    public ResponseEntity<List<TableResponseDTO>> getAllTables() {
        List<TableResponseDTO> allTables = tableService.getAllTables();
        return ResponseEntity.ok(allTables);
    }

    // Update a table
    @PutMapping("/admin/table/{id}")
    @Operation(summary = "Update a table", description = "Updates an existing table and returns the updated table")
    @ApiResponse(responseCode = "200", description = "Table updated successfully")

    public ResponseEntity<TableResponseDTO> updateTable(@PathVariable("id") long tableId, @RequestBody TableRequestDTO tableRequestDTO) {
        TableResponseDTO updatedTable = tableService.updateTable(tableId, tableRequestDTO);
        return ResponseEntity.ok(updatedTable);
    }

    // Delete a table
    @DeleteMapping("/admin/table/{id}")
    @Operation(summary = "Delete a table", description = "Deletes an existing table")
    @ApiResponse(responseCode = "200", description = "Table deleted successfully")

    public ResponseEntity<String> deleteTable(@PathVariable("id") long tableId) {
        tableService.deleteTable(tableId);
        return ResponseEntity.ok("Table with ID: " +tableId+ " deleted");
    }

}
