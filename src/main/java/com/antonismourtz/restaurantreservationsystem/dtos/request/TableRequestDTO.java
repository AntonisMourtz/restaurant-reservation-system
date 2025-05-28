package com.antonismourtz.restaurantreservationsystem.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TableRequestDTO {

    private Long tableId;
    private String tableName;
    private int tableCapacity;
    private boolean indoor;

}
