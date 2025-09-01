package com.antonismourtz.restaurantreservationsystem.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableRequestDTO {

    @Schema(description = "Unique identifier of the table", example = "12")
    private Long tableId;

    @Schema(description = "Name of the table", example = "Table 1")
    private String tableName;

    @Schema(description = "Maximum number of guests the table can accommodate", example = "4")
    private int tableCapacity;

    @Schema(description = "Indicates whether the table is located indoors", example = "true")
    private boolean indoor;

}
