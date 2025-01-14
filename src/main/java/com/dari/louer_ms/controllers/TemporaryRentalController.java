package com.dari.louer_ms.controllers;

import com.dari.louer_ms.commands.CreateTemporaryRentalCommand;
import com.dari.louer_ms.commands.UpdateTemporaryRentalCommand;
import com.dari.louer_ms.entities.TemporaryRental;
import com.dari.louer_ms.repositories.TemporaryRentalRepository;
import com.dari.louer_ms.services.RentalService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/temporary-rentals")
@RequiredArgsConstructor
public class TemporaryRentalController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;
    private final RentalService temporaryRentalService;

    // Nom du circuit breaker défini dans la configuration Resilience4j
    private static final String TEMPORARY_RENTAL_SERVICE = "temporaryRentalService";
    private final TemporaryRentalRepository temporaryRentalRepository;

    @PostMapping
    @CircuitBreaker(name = TEMPORARY_RENTAL_SERVICE, fallbackMethod = "createRentalFallback")
    public ResponseEntity<String> createTemporaryRental(@RequestBody TemporaryRental request) {
        String rentalId = UUID.randomUUID().toString();
        CreateTemporaryRentalCommand command = new CreateTemporaryRentalCommand(
                rentalId,
                request.getPropertyId(),
                request.getStartDate(),
                request.getEndDate(),
                request.getPrice()
        );
        commandGateway.sendAndWait(command);
        return ResponseEntity.ok("Temporary rental created successfully with ID: " + rentalId);
    }

    @PutMapping("/{rentalId}")
    @CircuitBreaker(name = TEMPORARY_RENTAL_SERVICE, fallbackMethod = "updateRentalFallback")
    public ResponseEntity<String> updateTemporaryRental(
            @PathVariable String rentalId,
            @RequestBody TemporaryRental request
    ) {
        UpdateTemporaryRentalCommand command = new UpdateTemporaryRentalCommand(
                rentalId,
                request.getStartDate(),
                request.getEndDate(),
                request.getPrice()
        );
        commandGateway.sendAndWait(command);
        return ResponseEntity.ok("Temporary rental updated successfully with ID: " + rentalId);
    }

    @GetMapping("/{rentalId}")
    @CircuitBreaker(name = TEMPORARY_RENTAL_SERVICE, fallbackMethod = "getRentalFallback")
    public ResponseEntity<TemporaryRental> getTemporaryRentalById(@PathVariable String rentalId) {
        return ResponseEntity.ok(temporaryRentalRepository.getRentalByRentalId(rentalId));
    }

    @GetMapping
    @CircuitBreaker(name = TEMPORARY_RENTAL_SERVICE, fallbackMethod = "getAllRentalsFallback")
    public ResponseEntity<List<TemporaryRental>> getAllTemporaryRentals() {
        return ResponseEntity.ok(temporaryRentalRepository.findAll());
    }

    // Méthodes de fallback pour le circuit breaker

    public ResponseEntity<String> createRentalFallback(TemporaryRental request, Throwable throwable) {
        return ResponseEntity.status(503)
                .body("Service unavailable. Please try creating the rental later.");
    }

    public ResponseEntity<String> updateRentalFallback(String rentalId, TemporaryRental request, Throwable throwable) {
        return ResponseEntity.status(503)
                .body("Service unavailable. Please try updating the rental later.");
    }

    public ResponseEntity<TemporaryRental> getRentalFallback(String rentalId, Throwable throwable) {
        TemporaryRental fallbackResponse = new TemporaryRental(
                rentalId, "unknown", "unknown", "unknown", 0.0);
        return ResponseEntity.ok(fallbackResponse);
    }

    public ResponseEntity<List<TemporaryRental>> getAllRentalsFallback(Throwable throwable) {
        return ResponseEntity.status(503)
                .body(null);
    }
}