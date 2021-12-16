package com.stedemo.repository;

import com.stedemo.model.Flight;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;


public interface FlightRepository extends ReactiveCrudRepository<Flight, String>, CustomFlightRepository {

}
