package com.antonismourtz.restaurantreservationsystem.service.impl;

import com.antonismourtz.restaurantreservationsystem.dtos.request.TableRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.TableResponseDTO;
import com.antonismourtz.restaurantreservationsystem.entity.RestaurantTable;
import com.antonismourtz.restaurantreservationsystem.exception.ResourceNotFoundException;
import com.antonismourtz.restaurantreservationsystem.mapper.TableMapper;
import com.antonismourtz.restaurantreservationsystem.repository.TableRepository;
import com.antonismourtz.restaurantreservationsystem.service.TableService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class TableServiceImpl implements TableService {

    private TableRepository tableRepository;

    @Override
    public TableResponseDTO createTable(TableRequestDTO tableRequestDTO) {
        // We convert the DTO (Request) to Entity (restaurantTable)
        RestaurantTable restaurantTable = TableMapper.TableRequestDtoToEntity(tableRequestDTO);
        //We save the Entity (restaurantTable) in DB
        RestaurantTable savedRestaurantTable = tableRepository.save(restaurantTable);

        return TableMapper.EntityToTableResponseDto(savedRestaurantTable);
    }

    @Override
    public TableResponseDTO getTableById(long tableId) {
        RestaurantTable restaurantTable = tableRepository.findById(tableId)
                .orElseThrow(()-> new ResourceNotFoundException("Table not found with ID: " + tableId));

        return TableMapper.EntityToTableResponseDto(restaurantTable);
    }

    @Override
    public List<TableResponseDTO> getAllTables() {
        List<RestaurantTable> allTables = tableRepository.findAll();
        return allTables.stream().map((restaurantTable) -> TableMapper.EntityToTableResponseDto(restaurantTable))
                .collect(Collectors.toList());

    }

    @Override
    public TableResponseDTO updateTable(long tableId, TableRequestDTO tableRequestDTO) {
        RestaurantTable restaurantTable = tableRepository.findById(tableId)
                .orElseThrow(()-> new ResourceNotFoundException("Table not found with ID: " + tableId));

        restaurantTable.setTableCapacity(tableRequestDTO.getTableCapacity());
        restaurantTable.setTableName(tableRequestDTO.getTableName());
        restaurantTable.setIndoor(tableRequestDTO.isIndoor());

        RestaurantTable updatedRestaurantTable = tableRepository.save(restaurantTable);
        return TableMapper.EntityToTableResponseDto(updatedRestaurantTable);
    }

    @Override
    public void deleteTable(long tableId) {

        RestaurantTable restaurantTable = tableRepository.findById(tableId)
                .orElseThrow(()-> new ResourceNotFoundException("Table not found with ID: " + tableId));
        tableRepository.delete(restaurantTable);
    }

}
