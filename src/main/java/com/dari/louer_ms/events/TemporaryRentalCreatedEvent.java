package com.dari.louer_ms.events;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TemporaryRentalCreatedEvent {
    private final String rentalId;
    private final String propertyId;
    private final String startDate;
    private final String endDate;
    private final double price;
}