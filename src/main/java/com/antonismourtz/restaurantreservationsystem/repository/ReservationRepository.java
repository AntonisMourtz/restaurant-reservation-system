package com.antonismourtz.restaurantreservationsystem.repository;

import com.antonismourtz.restaurantreservationsystem.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
