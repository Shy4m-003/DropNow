package com.scrop.dropnow.service.Implemantation;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Random;

@Service
public class PriceCalculationService {

    private final Random random = new Random();

    public double generateRandomDistance() {
        double randomDistance = 1 + (Math.random() * 9); // Random between 1 to 10 km
        return Math.round(randomDistance * 100.0) / 100.0; // Round to 2 decimal places// distance between 2 km and 10 km
    }

    public double getTimeMultiplier(LocalTime time) {
        int hour = time.getHour();

        if (hour >= 6 && hour < 10) return 1.5;      // Morning rush
        if (hour >= 17 && hour < 21) return 1.8;     // Evening rush
        if (hour >= 22 || hour < 5) return 2.0;      // Night
        return 1.0;                                  // Normal
    }

    public double getBaseFarePerKm(String vehicleType) {
        vehicleType = vehicleType.trim().toLowerCase();
        return switch (vehicleType) {
            case "two wheeler" -> 10.0;
            case "three wheeler" -> 15.0;
            case "four wheeler" -> 20.0;
            case "four wheeler-lux" -> 30.0;
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        };
    }

    public double calculateFare(String vehicleType, LocalTime time) {
        double distance = generateRandomDistance();
        double baseFare = getBaseFarePerKm(vehicleType);
        double timeMultiplier = getTimeMultiplier(time);

        return Math.round(distance * baseFare * timeMultiplier * 100.0) / 100.0; // round to 2 decimal places
    }
}
