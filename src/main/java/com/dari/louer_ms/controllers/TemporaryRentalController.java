package com.dari.louer_ms.controllers;

import com.dari.louer_ms.entities.TemporaryRental;
import com.dari.louer_ms.services.RentalService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class TemporaryRentalController {

    @Autowired
    private RentalService rentalService;

    // Créer une location temporaire
    @PostMapping
    public TemporaryRental createTemporaryRental(@RequestBody TemporaryRental rental) {
        return rentalService.createTemporaryRental(rental);
    }

    // Trouver des locations temporaires par propertyId et date
    @GetMapping("/search")
    @CircuitBreaker(name = "rentalCircuitBreaker", fallbackMethod = "fallbackRentals")
    public List<TemporaryRental> findRentals(
            @RequestParam String propertyId,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        return rentalService.findRentals(propertyId, startDate, endDate);
    }

    // Méthode fallback pour le circuit breaker en cas d'échec
    public List<TemporaryRental> fallbackRentals(String propertyId, String startDate, String endDate, Throwable ex) {
        return List.of(); // Retourne une liste vide en cas d'échec
    }
}
