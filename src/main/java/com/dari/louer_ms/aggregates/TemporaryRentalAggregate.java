package com.dari.louer_ms.aggregates;

import com.dari.louer_ms.commands.CreateTemporaryRentalCommand;
import com.dari.louer_ms.commands.UpdateTemporaryRentalCommand;
import com.dari.louer_ms.events.TemporaryRentalCreatedEvent;
import com.dari.louer_ms.events.TemporaryRentalUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
@Getter
public class TemporaryRentalAggregate {

    @AggregateIdentifier
    private String rentalId;
    private String propertyId;
    private String startDate;
    private String endDate;
    private double price;

    @CommandHandler
    public TemporaryRentalAggregate(CreateTemporaryRentalCommand command) {
        apply(new TemporaryRentalCreatedEvent(
                command.getRentalId(),
                command.getPropertyId(),
                command.getStartDate(),
                command.getEndDate(),
                command.getPrice()
        ));
    }

    @CommandHandler
    public void handle(UpdateTemporaryRentalCommand command) {
        apply(new TemporaryRentalUpdatedEvent(
                command.getRentalId(),
                command.getStartDate(),
                command.getEndDate(),
                command.getPrice()
        ));
    }

    public void on(TemporaryRentalCreatedEvent event) {
        this.rentalId = event.getRentalId();
        this.propertyId = event.getPropertyId();
        this.startDate = event.getStartDate();
        this.endDate = event.getEndDate();
        this.price = event.getPrice();
    }

    public void on(TemporaryRentalUpdatedEvent event) {
        this.startDate = event.getStartDate();
        this.endDate = event.getEndDate();
        this.price = event.getPrice();
    }
}