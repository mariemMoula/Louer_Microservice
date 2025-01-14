package com.dari.louer_ms.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateGuaranteeStatusCommand {

    @TargetAggregateIdentifier
    private final String guaranteeId;
    private final String status;

    public UpdateGuaranteeStatusCommand(String guaranteeId, String status) {
        this.guaranteeId = guaranteeId;
        this.status = status;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public String getStatus() {
        return status;
    }
}