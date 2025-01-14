package com.dari.louer_ms.commands;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class CreateGuaranteeCommand {
    @TargetAggregateIdentifier
    private String guaranteeId;
    private String userId;
    private String documentUrl;
}
