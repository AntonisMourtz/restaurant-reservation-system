package com.antonismourtz.restaurantreservationsystem.dtos.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableResponseDTO {

    private Long tableId;
    private String tableName;
    private int tableCapacity;
    private boolean indoor;

}
