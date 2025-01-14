package com.dari.louer_ms.projections;

import com.dari.louer_ms.entities.TemporaryRental;
import com.dari.louer_ms.events.TemporaryRentalCreatedEvent;
import com.dari.louer_ms.events.TemporaryRentalUpdatedEvent;
import com.dari.louer_ms.repositories.TemporaryRentalRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class TemporaryRentalProjection {

    private final TemporaryRentalRepository repository;

    public TemporaryRentalProjection(TemporaryRentalRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(TemporaryRentalCreatedEvent event) {
        TemporaryRental rental = new TemporaryRental(
                event.getRentalId(),
                event.getPropertyId(),
                event.getStartDate(),
                event.getEndDate(),
                event.getPrice()
        );
        repository.save(rental);
    }

    @EventHandler
    public void on(TemporaryRentalUpdatedEvent event) {
        TemporaryRental rental = repository.findById(event.getRentalId()).orElseThrow();
        rental.setStartDate(event.getStartDate());
        rental.setEndDate(event.getEndDate());
        rental.setPrice(event.getPrice());
        repository.save(rental);
    }
}