package com.dari.louer_ms.aggregates;

import com.dari.louer_ms.commands.CreateGuaranteeCommand;
import com.dari.louer_ms.events.GuaranteeCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.List;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Aggregate
public class GuaranteeAggregate {

    @AggregateIdentifier
    private String guaranteeId;
    private String userId;
    private String documentUrl;

    @CommandHandler
    public GuaranteeAggregate(CreateGuaranteeCommand command) {
        apply(new GuaranteeCreatedEvent(
                command.getGuaranteeId(),
                command.getUserId(),
                command.getDocumentUrl()
        ));
    }

    @CommandHandler
    public void handle(UpdateGuaranteeCommand command) {
        apply(new GuaranteeUpdatedEvent(
                command.getGuaranteeId(),
                command.getDocumentUrl()
        ));
    }

    @CommandHandler
    public void handle(DeleteGuaranteeCommand command) {
        apply(new GuaranteeDeletedEvent(command.getGuaranteeId()));
    }

    public void on(GuaranteeCreatedEvent event) {
        this.guaranteeId = event.getGuaranteeId();
        this.userId = event.getUserId();
        this.documentUrl = event.getDocumentUrl();
    }

    public void on(GuaranteeUpdatedEvent event) {
        this.documentUrl = event.getDocumentUrl();
    }

    public void on(GuaranteeDeletedEvent event) {
        this.guaranteeId = null;
        this.userId = null;
        this.documentUrl = null;
    }
}