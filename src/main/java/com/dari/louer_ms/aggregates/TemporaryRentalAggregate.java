package com.dari.louer_ms.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class TemporaryRentalAggregate {

    @AggregateIdentifier
    private String rentalId;
    private String propertyId;
    private String tenantId;
    private LocalDate startDate;
    private LocalDate endDate;
    private double price;
    private RentalStatus status;

    public TemporaryRentalAggregate() {
        // Required by Axon
    }

    @CommandHandler
    public TemporaryRentalAggregate(CreateTemporaryRentalCommand command) {
        if (command.getStartDate().isAfter(command.getEndDate())) {
            throw new IllegalArgumentException("Start date must be before end date");
        }

        apply(new TemporaryRentalCreatedEvent(
                command.getRentalId(),
                command.getPropertyId(),
                command.getTenantId(),
                command.getStartDate(),
                command.getEndDate(),
                command.getPrice()
        ));
    }

    @EventSourcingHandler
    public void on(TemporaryRentalCreatedEvent event) {
        this.rentalId = event.getRentalId();
        this.propertyId = event.getPropertyId();
        this.tenantId = event.getTenantId();
        this.startDate = event.getStartDate();
        this.endDate = event.getEndDate();
        this.price = event.getPrice();
        this.status = RentalStatus.PENDING;
    }

    @CommandHandler
    public void handle(UpdateRentalStatusCommand command) {
        apply(new RentalStatusUpdatedEvent(command.getRentalId(), command.getStatus()));
    }

    @EventSourcingHandler
    public void on(RentalStatusUpdatedEvent event) {
        this.status = event.getStatus();
    }
}
