package com.antonismourtz.restaurantreservationsystem.dtos.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableRequestDTO {

    private Long tableId;
    private String tableName;
    private int tableCapacity;
    private boolean indoor;

}
