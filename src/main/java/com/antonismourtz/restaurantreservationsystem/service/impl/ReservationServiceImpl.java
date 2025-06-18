package com.antonismourtz.restaurantreservationsystem.service.impl;

import com.antonismourtz.restaurantreservationsystem.dtos.request.ReservationRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.ReservationResponseDTO;
import com.antonismourtz.restaurantreservationsystem.entity.Reservation;
import com.antonismourtz.restaurantreservationsystem.entity.RestaurantTable;
import com.antonismourtz.restaurantreservationsystem.exception.ActiveReservationsException;
import com.antonismourtz.restaurantreservationsystem.exception.BusinessLogicException;
import com.antonismourtz.restaurantreservationsystem.exception.ReservationNotPossibleException;
import com.antonismourtz.restaurantreservationsystem.mapper.ReservationMapper;
import com.antonismourtz.restaurantreservationsystem.repository.OpeningHoursRepository;
import com.antonismourtz.restaurantreservationsystem.repository.ReservationRepository;
import com.antonismourtz.restaurantreservationsystem.repository.TableRepository;
import com.antonismourtz.restaurantreservationsystem.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private TableRepository tableRepository;
    private ReservationRepository reservationRepository;
    private OpeningHoursRepository openingHoursRepository;

    @Override
    public ReservationResponseDTO makeReservation(ReservationRequestDTO reservationRequestDTO) {
        // We check the hours are valid
        if(isReservationTimeValid(reservationRequestDTO)) {
            throw new BusinessLogicException("Start time must be earlier than end time.");
        }
        // The restaurant must be open at this day
        if(!checkDayOfReservation(reservationRequestDTO)) {
            throw new ReservationNotPossibleException("The restaurant is closed at this day.");
        }
        if(isReservationWithinOpeningHours(reservationRequestDTO)) {
            throw new ReservationNotPossibleException("Reservation time is outside of the restaurant's opening hours.");
        }
        RestaurantTable savedTable = findAvailableTable(reservationRequestDTO);
        if (savedTable==null) {
            throw new ReservationNotPossibleException("The reservation was not possible.");
        }
        Reservation reservation = ReservationMapper.mapToReservation(reservationRequestDTO);
        reservation.setRestaurantTable(savedTable);

        Reservation savedReservation = reservationRepository.save(reservation);
        return ReservationMapper.mapReservationToReservationResponseDTO(savedReservation);
    }

    @Override
    public void deleteReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation with id " + reservationId + " not found."));

        reservationRepository.delete(reservation);
    }

    @Override
    public void deleteAllReservations() {
        reservationRepository.deleteAll();
    }

    @Override
    public boolean isReservationTimeValid(ReservationRequestDTO reservationRequestDTO) {
        return reservationRequestDTO.getReservationStartTime().isAfter(reservationRequestDTO.getReservationEndTime());
    }

    public boolean checkDayOfReservation(ReservationRequestDTO reservationRequestDTO) {
       return openingHoursRepository.findByDayOfWeek(reservationRequestDTO.getReservationDay()).get().isOpen();
    }

    @Override
    public boolean isReservationWithinOpeningHours(ReservationRequestDTO reservationRequestDTO) {
        var reservationStartTime= reservationRequestDTO.getReservationStartTime();
        var reservationEndTime = reservationRequestDTO.getReservationEndTime();
        var openTime = openingHoursRepository.findByDayOfWeek(reservationRequestDTO.getReservationDay()).get().getOpenTime();
        var closeTime= openingHoursRepository.findByDayOfWeek(reservationRequestDTO.getReservationDay()).get().getCloseTime();

        return reservationStartTime.isBefore(openTime)||reservationEndTime.isAfter(closeTime);
    }

    @Override
    public List<ReservationResponseDTO> getAllReservations() {
        List<Reservation> allReservations = reservationRepository.findAll();
        return allReservations.stream().map((reservation ) -> ReservationMapper.mapReservationToReservationResponseDTO(reservation))
                .collect(Collectors.toList());
    }

    public RestaurantTable findAvailableTable(ReservationRequestDTO reservationRequestDTO) {
        var newEnd = reservationRequestDTO.getReservationEndTime();
        var newStart = reservationRequestDTO.getReservationStartTime();
        RestaurantTable savedTable = null;

        List<RestaurantTable> allTables = tableRepository.findAll();

        for (RestaurantTable restaurantTable : allTables) {
            // Check if this table is outdoor or indoor
            if (reservationRequestDTO.isIndoorPreference() == restaurantTable.isIndoor()) {
                //Check if the people in the reservation can fit at the table.
                if (reservationRequestDTO.getNumberOfGuests() <= restaurantTable.getTableCapacity()) {

                    // We check if the specific table is already reserved on the requested day.
                    // If there are no reservations for that table on that day, the table is available and can be reserved.
                    if (!reservationRepository.existsByRestaurantTable_TableId_AndReservationDay(restaurantTable.getTableId(), reservationRequestDTO.getReservationDay())) {
                        savedTable = restaurantTable;
                    // If there are existing reservations, we compare their time slots with the requested time.
                    }else {
                        List<Reservation> existingReservations = reservationRepository.findByRestaurantTable_TableId_AndReservationDay((restaurantTable.getTableId()), reservationRequestDTO.getReservationDay());
                        boolean conflictFound = false;

                        for (Reservation existing : existingReservations) {
                            if (!(newEnd.isBefore(existing.getReservationStartTime())
                                    || newStart.isAfter(existing.getReservationEndTime()))) {
                                // If there is no time conflict with any existing reservation,
                                // the table is available, and we proceed with the reservation.
                                conflictFound = true;
                                break;
                            }
                        }
                        if (!conflictFound) {
                            savedTable = restaurantTable;
                        }
                    }
                }
            }
        }
        return savedTable;
    }

    @Override
    public boolean existsActiveReservations() {
        return !(reservationRepository.count() == 0);
    }
}