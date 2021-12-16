package com.stedemo.service;

import com.stedemo.model.Flight;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public interface FlightService {
    Mono<Flight> getFlightNumber(LocalDate date, String departurePoint, String arrivalPoint);

    Mono<Flight> getFlightPrice(final int flightNumber,LocalDate flightDate);
}
