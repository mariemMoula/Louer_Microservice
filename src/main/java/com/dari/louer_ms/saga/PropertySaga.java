package com.dari.louer_ms.saga;

import com.dari.louer_ms.events.PropertyCreatedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
public class PropertySaga {


    private final NotificationService notificationService;

    public PropertySaga(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @EventHandler
    public void on(PropertyCreatedEvent event) {
        // Notify users with pre-saved criteria
        notificationService.sendAlert(event.getOwnerId(), "A new property matching your criteria is available!");
    }
}