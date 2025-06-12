package com.antonismourtz.restaurantreservationsystem.repository;

import com.antonismourtz.restaurantreservationsystem.entity.Reservation;
import com.antonismourtz.restaurantreservationsystem.entity.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    boolean existsByRestaurantTable_TableId_AndReservationDay(Long tableId, DayOfWeek reservationDay);
    List<Reservation> findByRestaurantTable_TableId_AndReservationDay(Long restaurantTableTableId, DayOfWeek reservationDay);
}
