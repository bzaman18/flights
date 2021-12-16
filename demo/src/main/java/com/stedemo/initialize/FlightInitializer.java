package com.stedemo.initialize;

import com.stedemo.model.Flight;
import com.stedemo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@Profile("!test")
public class FlightInitializer implements CommandLineRunner {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public void run(String... args) {
        initialDataSetup();
    }

    private List<Flight> getData(){
        return Arrays.asList(
                new Flight("ABC01", "XVZ10",1212,150d, LocalDate.now()),
                new Flight("ABC02", "PRZ10",1214,154d, LocalDate.now()),
                new Flight("ABC03", "ABC01",1216,153d, LocalDate.now()));
    }


    private void initialDataSetup() {
        flightRepository.deleteAll()
                .thenMany(Flux.fromIterable(getData()))
                .flatMap(flightRepository::save)
                .thenMany(flightRepository.findAll())
                .subscribe(flight -> {
                    System.out.println("flights Inserted from CommandLineRunner " + flight);
                });
    }

}