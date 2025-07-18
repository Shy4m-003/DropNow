package com.scrop.dropnow.service.Implemantation;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Random;

@Service
public class PriceCalculationService {

    private final Random random = new Random();

    public double generateRandomDistance() {
        return 2 + (8 * random.nextDouble()); // distance between 2 km and 10 km
    }

    public double getTimeMultiplier(LocalTime time) {
        int hour = time.getHour();

        if (hour >= 6 && hour < 10) return 1.5;      // Morning rush
        if (hour >= 17 && hour < 21) return 1.8;     // Evening rush
        if (hour >= 22 || hour < 5) return 2.0;      // Night
        return 1.0;                                  // Normal
    }

    public double getBaseFarePerKm(String vehicleType) {
        return switch (vehicleType.toLowerCase()) {
            case "bike" -> 10.0;
            case "auto" -> 15.0;
            case "car" -> 20.0;
            default -> throw new IllegalArgumentException("Unknown vehicle type");
        };
    }

    public double calculateFare(String vehicleType, LocalTime time) {
        double distance = generateRandomDistance();
        double baseFare = getBaseFarePerKm(vehicleType);
        double timeMultiplier = getTimeMultiplier(time);

        return Math.round(distance * baseFare * timeMultiplier * 100.0) / 100.0; // round to 2 decimal places
    }
}
