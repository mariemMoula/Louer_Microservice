package com.dari.louer_ms.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyCreatedEvent {
    private String propertyId;
    private String location;
    private int size;
    private double price;
    private boolean available;
}
