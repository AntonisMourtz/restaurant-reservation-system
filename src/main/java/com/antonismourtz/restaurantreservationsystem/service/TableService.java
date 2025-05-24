package com.antonismourtz.restaurantreservationsystem.service;

import com.antonismourtz.restaurantreservationsystem.dtos.request.TableRequestDTO;
import com.antonismourtz.restaurantreservationsystem.dtos.response.TableResponseDTO;

public interface TableService {
    TableResponseDTO createTable(TableRequestDTO tableRequestDTO);
}
