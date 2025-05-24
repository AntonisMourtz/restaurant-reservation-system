package com.antonismourtz.restaurantreservationsystem.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TableResponseDTO {

    private Long tableId;
    private String tableName;
    private int tableCapacity;
    private boolean indoor;

}
