package com.dari.louer_ms.commands;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAlertCommand {
    @TargetAggregateIdentifier
    private String alertId;
    private String userId;
    private String criteria;
}
