package com.antonismourtz.restaurantreservationsystem.repository;

import com.antonismourtz.restaurantreservationsystem.entity.OpeningHours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.util.Optional;

public interface OpeningHoursRepository extends JpaRepository<OpeningHours, Long> {
    Optional<OpeningHours> findByDayOfWeek(DayOfWeek dayOfWeek);
}
