package com.antonismourtz.restaurantreservationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @Enumerated(EnumType.STRING)
    @Column(name = "reservation_day", nullable = false)
    private DayOfWeek reservationDay;

    @Column(name = "reservation_start_time", nullable = false)
    private LocalTime reservationStartTime;

    @Column(name = "reservation_end_time", nullable = false)
    private LocalTime reservationEndTime;

    @Column(name = "number_of_guests", nullable = false)
    private int numberOfGuests;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_email", nullable = false)
    private String customerEmail;

    @Column(name = "customer_phone", nullable = false)
    private String customerPhone;

    @Column(name = "indoor_preference", nullable = false)
    private boolean indoorPreference;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private RestaurantTable restaurantTable;

}
