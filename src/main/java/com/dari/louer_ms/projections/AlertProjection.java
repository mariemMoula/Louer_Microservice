package com.dari.louer_ms.projections;

import com.dari.louer_ms.entities.Alert;
import com.dari.louer_ms.events.AlertCreatedEvent;
import com.dari.louer_ms.repositories.AlertRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class AlertProjection {

    private final AlertRepository alertRepository;

    public AlertProjection(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @EventHandler
    public void on(AlertCreatedEvent event) {
        Alert alert = new Alert();
        alert.setAlertId(event.getAlertId());
        alert.setUserId(event.getUserId());
        alert.setCriteria(event.getCriteria());
        alertRepository.save(alert);
    }
}