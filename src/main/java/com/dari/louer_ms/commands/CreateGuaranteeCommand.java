package com.dari.louer_ms.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateGuaranteeCommand {
    @TargetAggregateIdentifier
    private String guaranteeId;
    private String userId;
    private String documentUrl;
}
