package com.stedemo.controller;

import com.stedemo.model.Flight;
import com.stedemo.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

import static com.stedemo.constants.FlightConstants.FLIGHT_END_POINT_V1;

@RestController
@RequestMapping(path=FLIGHT_END_POINT_V1)
public class DemoController {

    @Autowired
   private FlightService flightService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @GetMapping( path = "/{departureAirport}")
    public ResponseEntity<Mono<Flight>> getFlightNumber(
            @PathVariable ("flightDate") LocalDate date,
            @PathVariable ("departureAirport") String departure,
            @PathVariable ("departureAirport") String arrival){
      Mono<Flight> flight = flightService.getFlightNumber(date,departure,arrival);
        HttpStatus status = flight != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<Flight>>(flight,status);
    }
    @GetMapping( path = "/flight")
    public ResponseEntity<Mono<Flight>> getFlightPrice(
            @PathVariable ("flightDate") LocalDate date,
            @PathVariable ("flightNumber") Integer flightNo){
        Mono<Flight> flight = flightService.getFlightPrice(flightNo,date);
        HttpStatus status = flight != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<Flight>>(flight,status);
    }

}
