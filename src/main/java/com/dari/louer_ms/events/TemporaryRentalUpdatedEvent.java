package com.dari.louer_ms.events;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TemporaryRentalUpdatedEvent {
    private final String rentalId;
    private final String startDate;
    private final String endDate;
    private final double price;
}
