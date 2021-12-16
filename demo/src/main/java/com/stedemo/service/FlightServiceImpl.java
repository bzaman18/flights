package com.stedemo.service;

import com.stedemo.model.Flight;
import com.stedemo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Component
public class FlightServiceImpl implements FlightService{

    @Autowired
    FlightRepository flightRepository;


    @Override
    public Mono<Flight> getFlightNumber(LocalDate date, String departurePoint, String arrivalPoint) {
        return flightRepository.getFlightInfo(date,departurePoint,arrivalPoint);
    }

    @Override
    public Mono<Flight> getFlightPrice(final int flightNumber,LocalDate flightDate) {
        return flightRepository.getFlightPrice(flightNumber, flightDate);
    }

}
