package com.antonismourtz.restaurantreservationsystem.mapper;

import com.antonismourtz.restaurantreservationsystem.dtos.request.TableRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.TableResponseDTO;
import com.antonismourtz.restaurantreservationsystem.entity.RestaurantTable;

public class TableMapper {
    // DTO -> Entity
    public static RestaurantTable TableRequestDtoToEntity(TableRequestDTO tableRequestDTO) {
        return new RestaurantTable(
                tableRequestDTO.getTableId(),
                tableRequestDTO.getTableName(),
                tableRequestDTO.getTableCapacity(),
                tableRequestDTO.isIndoor()
        );
    }
    // Entity -> DTO
    public static TableResponseDTO EntityToTableResponseDto(RestaurantTable restaurantTable) {
        return new TableResponseDTO(
                restaurantTable.getTableId(),
                restaurantTable.getTableName(),
                restaurantTable.getTableCapacity(),
                restaurantTable.isIndoor()
        );
    }
}
