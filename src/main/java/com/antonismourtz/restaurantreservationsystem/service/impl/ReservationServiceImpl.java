package com.antonismourtz.restaurantreservationsystem.service.impl;

import com.antonismourtz.restaurantreservationsystem.dtos.request.ReservationRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.ReservationResponseDTO;
import com.antonismourtz.restaurantreservationsystem.entity.Reservation;
import com.antonismourtz.restaurantreservationsystem.entity.RestaurantTable;
import com.antonismourtz.restaurantreservationsystem.exception.BusinessLogicException;
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
            throw new BusinessLogicException("The restaurant is closed at this day.");
        }
        if(isReservationWithinOpeningHours(reservationRequestDTO)) {
            throw new BusinessLogicException("Reservation time is outside of the restaurant's opening hours.");
        }

        Reservation reservation = ReservationMapper.mapToReservation(reservationRequestDTO);
        //for testing we add the first table
        RestaurantTable table = tableRepository.findAll().iterator().next();

        reservation.setRestaurantTable(table);

        Reservation savedReservation = reservationRepository.save(reservation);
        return ReservationMapper.mapReservationToReservationResponseDTO(savedReservation);
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
}