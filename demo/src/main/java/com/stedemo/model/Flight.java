package com.stedemo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "flights")
public class Flight {

    @Id
    private String id;

    private String departureCode;
    private String arrivalCode;
    private Integer flightNumber;
    private Double price;
    private LocalDate date;

    public Flight(){}

    public Flight(String departureCode, String arrivalCode, Integer flightNumber, Double price, LocalDate date) {
        this.departureCode = departureCode;
        this.arrivalCode = arrivalCode;
        this.flightNumber = flightNumber;
        this.price = price;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartureCode() {
        return departureCode;
    }

    public void setDepartureCode(String departureCode) {
        this.departureCode = departureCode;
    }

    public String getArrivalCode() {
        return arrivalCode;
    }

    public void setArrivalCode(String arrivalCode) {
        this.arrivalCode = arrivalCode;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", departureCode='" + departureCode + '\'' +
                ", arrivalCode='" + arrivalCode + '\'' +
                ", flightNumber=" + flightNumber +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
