package com.antonismourtz.restaurantreservationsystem.service;

import com.antonismourtz.restaurantreservationsystem.dtos.request.TableRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.TableResponseDTO;

import java.util.List;


public interface TableService {
    TableResponseDTO createTable(TableRequestDTO tableRequestDTO);

    TableResponseDTO getTableById(long tableId);

    List<TableResponseDTO> getAllTables();

    TableResponseDTO updateTable(long tableId, TableRequestDTO tableRequestDTO);

    void deleteTable(long tableId);


}
