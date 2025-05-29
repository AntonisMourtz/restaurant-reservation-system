package com.antonismourtz.restaurantreservationsystem.repository;

import com.antonismourtz.restaurantreservationsystem.entity.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface TableRepository extends JpaRepository<RestaurantTable, Long> {

}
