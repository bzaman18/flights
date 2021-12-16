package com.stedemo.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.stedemo.model.Flight;
import com.stedemo.repository.CustomFlightRepository;
import com.stedemo.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;


@ExtendWith(MockitoExtension.class)
public class FlightServiceImplTest {

    @InjectMocks
    private FlightServiceImpl service;

    @Mock
    private FlightRepository repository;

    @Mock
    private CustomFlightRepository customFlightRepository;

    @Test
    void test_getFlightInfo(){
        String id = "1212";
        LocalDate date = LocalDate.now();
        String departurePoint = "";
        String arrivalPoint = "";

        Flight data = new  Flight("ABC123", "ZXY123", 121, 154d, date);
        Mono<Flight> source = Mono.just(data);
        when(FlightRepository.getFlightInfo(date,departurePoint,arrivalPoint).thenReturn(source));
        when(customFlightRepository.getFlightInfo(date,departurePoint,arrivalPoint).thenReturn(source));
        StepVerifier.create(service.getFlightNumber(date,departurePoint,arrivalPoint)).assertNext(person ->
                assertThat(person).hasNoNullFieldsOrProperties()).verifyComplete();
    }

}
