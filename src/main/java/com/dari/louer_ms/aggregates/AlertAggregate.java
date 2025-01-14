package com.dari.louer_ms.aggregates;
import com.dari.louer_ms.commands.CreateAlertCommand;
import com.dari.louer_ms.events.AlertCreatedEvent;
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
public class AlertAggregate {
    @AggregateIdentifier
    private String alertId;
    private String userId;
    private String criteria;

    @CommandHandler
    public AlertAggregate(CreateAlertCommand command) {
        apply(new AlertCreatedEvent(
                command.getAlertId(),
                command.getUserId(),
                command.getCriteria()
        ));
    }

    @EventSourcingHandler
    public void on(AlertCreatedEvent event) {
        this.alertId = event.getAlertId();
        this.userId = event.getUserId();
        this.criteria = event.getCriteria();
    }
}
