package com.antonismourtz.restaurantreservationsystem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
        info = @Info(
                title = "Restaurant Reservation System",
                description = "This API powers a restaurant reservation system where administrators can manage tables" +
                        " and opening hours, and customers can book reservations. The system automatically assigns the most" +
                        " suitable table based on availability."
        )
)
@SpringBootApplication
public class RestaurantReservationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantReservationSystemApplication.class, args);
	}

}
