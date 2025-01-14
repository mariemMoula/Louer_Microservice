package com.dari.louer_ms.saga;

import com.dari.louer_ms.entities.Alert;
import com.dari.louer_ms.events.PropertyCreatedEvent;
import com.dari.louer_ms.services.AlertService;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.spring.stereotype.Saga;

@Saga
public class PropertySaga {


    private final AlertService notificationService;

    public PropertySaga(AlertService notificationService) {
        this.notificationService = notificationService;
    }

    @EventHandler
    public void on(PropertyCreatedEvent event) {
        // Notify users with pre-saved criteria
        notificationService.createAlert(new Alert(null, event.getPropertyId(), "A new property matching your criteria is" +
                " " +
                "available!"));
    }
}