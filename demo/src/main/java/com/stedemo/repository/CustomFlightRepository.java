package com.stedemo.repository;

import com.stedemo.model.Flight;
import org.springframework.data.mongodb.repository.Query;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface CustomFlightRepository {
    Mono<Flight> getFlightInfo(LocalDate flightDate, final String departureCode, final String arrivalCode);
    Mono<Flight> getFlightPrice(final int flightNumber,LocalDate flightDate);

}
