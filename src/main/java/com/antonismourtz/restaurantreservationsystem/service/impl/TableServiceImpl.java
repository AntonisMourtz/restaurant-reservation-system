package com.antonismourtz.restaurantreservationsystem.service.impl;

import com.antonismourtz.restaurantreservationsystem.dtos.request.TableRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.TableResponseDTO;
import com.antonismourtz.restaurantreservationsystem.entity.RestaurantTable;
import com.antonismourtz.restaurantreservationsystem.mapper.TableMapper;
import com.antonismourtz.restaurantreservationsystem.repository.TableRepository;
import com.antonismourtz.restaurantreservationsystem.service.TableService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
