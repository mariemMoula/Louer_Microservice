package com.dari.louer_ms.aggregates;


import com.dari.louer_ms.commands.CreatePropertyCommand;
import com.dari.louer_ms.commands.UpdatePropertyCommand;
import com.dari.louer_ms.events.PropertyCreatedEvent;
import com.dari.louer_ms.events.PropertyUpdatedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Aggregate
public class PropertyAggregate {

    @AggregateIdentifier
    private String propertyId;
    private String location;
    private int size;
    private double price;
    private boolean available;

    // Handler for CreatePropertyCommand
    @CommandHandler
    public PropertyAggregate(CreatePropertyCommand command) {
        apply(new PropertyCreatedEvent(
                command.getPropertyId(),
                command.getLocation(),
                command.getSize(),
                command.getPrice(),
                command.isAvailable()
        ));
    }

    // Handler for UpdatePropertyCommand
    @CommandHandler
    public void handle(UpdatePropertyCommand command) {
        apply(new PropertyUpdatedEvent(
                command.getPropertyId(),
                command.getLocation(),
                command.getSize(),
                command.getPrice(),
                command.isAvailable()
        ));
    }

    // Event Sourcing for PropertyCreatedEvent
    @EventSourcingHandler
    public void on(PropertyCreatedEvent event) {
        this.propertyId = event.getPropertyId();
        this.location = event.getLocation();
        this.size = event.getSize();
        this.price = event.getPrice();
        this.available = event.isAvailable();
    }

    // Event Sourcing for PropertyUpdatedEvent
    @EventSourcingHandler
    public void on(PropertyUpdatedEvent event) {
        this.location = event.getLocation();
        this.size = event.getSize();
        this.price = event.getPrice();
        this.available = event.isAvailable();
    }
}