package com.dari.louer_ms.commands;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class DeleteGuaranteeCommand {
    @TargetAggregateIdentifier
    private String guaranteeId;
}