package com.dari.louer_ms.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@AllArgsConstructor
public class UpdateTemporaryRentalCommand {
    @TargetAggregateIdentifier
    private final String rentalId;
    private final String startDate;
    private final String endDate;
    private final double price;
}
