package com.dari.louer_ms.aggregates;

import com.dari.louer_ms.events.GuaranteeCreatedEvent;
import com.dari.louer_ms.events.GuaranteeStatusUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class GuaranteeAggregate {

    @AggregateIdentifier
    private String guaranteeId;
    private String tenantId;
    private String propertyId;
    private GuaranteeStatus status;
    private List<String> documents; // Paths to scanned documents

    public GuaranteeAggregate() {
        // Required by Axon
    }

    @CommandHandler
    public GuaranteeAggregate(CreateGuaranteeCommand command) {
        if (command.getDocuments() == null || command.getDocuments().isEmpty()) {
            throw new IllegalArgumentException("Documents must be provided");
        }

        // Emit event
        apply(new GuaranteeCreatedEvent(
                command.getGuaranteeId(),
                command.getTenantId(),
                command.getPropertyId(),
                command.getDocuments()
        ));
    }

    @EventSourcingHandler
    public void on(GuaranteeCreatedEvent event) {
        this.guaranteeId = event.getGuaranteeId();
        this.tenantId = event.getTenantId();
        this.propertyId = event.getPropertyId();
        this.documents = event.getDocuments();
        this.status = GuaranteeStatus.PENDING;
    }

    @CommandHandler
    public void handle(UpdateGuaranteeStatusCommand command) {
        apply(new GuaranteeStatusUpdatedEvent(command.getGuaranteeId(), command.getStatus()));
    }

    @EventSourcingHandler
    public void on(GuaranteeStatusUpdatedEvent event) {
        this.status = event.getStatus();
    }
}