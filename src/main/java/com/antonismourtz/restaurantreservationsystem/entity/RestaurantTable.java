package com.antonismourtz.restaurantreservationsystem.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurant_table")
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableId;

    @Column(name = "table_name", unique = true, nullable = false)
    private String tableName;

    @Column(name = "table_capacity", nullable = false)
    private int tableCapacity;

    @Column(name = "indoor", nullable = false)
    private boolean indoor;

}
