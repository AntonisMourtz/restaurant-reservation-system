package com.antonismourtz.restaurantreservationsystem.repository;

import com.antonismourtz.restaurantreservationsystem.entity.OpeningHours;
import com.antonismourtz.restaurantreservationsystem.enums.DayOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OpeningHoursRepository extends JpaRepository<OpeningHours, Long> {
    Optional<OpeningHours> findByDayOfWeek(DayOfWeek dayOfWeek);
}
