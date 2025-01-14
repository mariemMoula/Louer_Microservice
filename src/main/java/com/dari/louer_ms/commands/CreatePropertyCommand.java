package com.dari.louer_ms.commands;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePropertyCommand {
    @TargetAggregateIdentifier
    private String propertyId;
    private String location;
    private int size;
    private double price;
    private boolean available;
}
