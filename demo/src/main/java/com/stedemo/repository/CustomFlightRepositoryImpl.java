package com.stedemo.repository;

import com.stedemo.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import reactor.core.publisher.Mono;

import java.time.LocalDate;

public class CustomFlightRepositoryImpl implements CustomFlightRepository{

    private final ReactiveMongoTemplate mongoTemplate;

    @Autowired
    public CustomFlightRepositoryImpl(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    @Override
    public Mono<Flight> getFlightInfo(LocalDate flightDate, String departureCode, String arrivalCode) {
        Query query = new Query(Criteria.where("date").is(flightDate))
                .addCriteria(Criteria.where("departureCode").is(departureCode))
                .addCriteria(Criteria.where("arrivalCode").is(arrivalCode));
        return mongoTemplate.findOne(query, Flight.class);
    }

    @Override
    public Mono<Flight> getFlightPrice(int flightNumber, LocalDate flightDate) {
        Query query = new Query(Criteria.where("date").is(flightDate))
                .addCriteria(Criteria.where("flightNumber").is(flightNumber));
        return mongoTemplate.findOne(query, Flight.class);
    }
}
