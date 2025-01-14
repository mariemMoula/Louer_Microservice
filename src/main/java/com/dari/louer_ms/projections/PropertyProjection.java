package com.dari.louer_ms.projections;

import com.dari.louer_ms.entities.Property;
import com.dari.louer_ms.events.PropertyCreatedEvent;
import com.dari.louer_ms.events.PropertyUpdatedEvent;
import com.dari.louer_ms.repositories.PropertyRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class PropertyProjection {

    @Autowired
    private PropertyRepository propertyRepository;

    @EventHandler
    public void on(PropertyCreatedEvent event) {
        Property property = new Property();
        property.setPropertyId(event.getPropertyId());
        property.setLocation(event.getLocation());
        property.setSize(event.getSize());
        property.setPrice(event.getPrice());
        property.setAvailable(event.isAvailable());
        propertyRepository.save(property);
    }

    @EventHandler
    public void on(PropertyUpdatedEvent event) {
        Property property = propertyRepository.findById(event.getPropertyId()).orElse(null);
        if (property != null) {
            property.setLocation(event.getLocation());
            property.setSize(event.getSize());
            property.setPrice(event.getPrice());
            property.setAvailable(event.isAvailable());
            propertyRepository.save(property);
        }
    }
}
