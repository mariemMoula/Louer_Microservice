package com.dari.louer_ms.projections;

import com.dari.louer_ms.entities.Guarantee;
import com.dari.louer_ms.events.GuaranteeCreatedEvent;
import com.dari.louer_ms.events.GuaranteeDeletedEvent;
import com.dari.louer_ms.events.GuaranteeUpdatedEvent;
import com.dari.louer_ms.repositories.GuaranteeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GuaranteeProjection {

    private final Map<String, Guarantee> guaranteeMap = new HashMap<>();

    // Méthode pour ajouter une garantie à la projection
    @EventHandler
    public void on(GuaranteeCreatedEvent event) {
        Guarantee guarantee = new Guarantee();
        guarantee.setGuaranteeId(event.getGuaranteeId());
        guarantee.setUserId(event.getUserId());
        guarantee.setDocumentUrl(event.getDocumentUrl());
        guaranteeMap.put(event.getGuaranteeId(), guarantee);
    }

    // Méthode pour mettre à jour une garantie dans la projection
    @EventHandler
    public void on(GuaranteeUpdatedEvent event) {
        Guarantee guarantee = guaranteeMap.get(event.getGuaranteeId());
        if (guarantee != null) {
            guarantee.setDocumentUrl(event.getDocumentUrl());
        }
    }

    // Méthode pour supprimer une garantie de la projection
    @EventHandler
    public void on(GuaranteeDeletedEvent event) {
        guaranteeMap.remove(event.getGuaranteeId());
    }

    // Méthode pour obtenir toutes les garanties (projections)
    public List<Guarantee> getAllGuarantees() {
        return new ArrayList<>(guaranteeMap.values());
    }

    // Méthode pour obtenir une garantie par son ID
    public Guarantee getGuaranteeById(String guaranteeId) {
        return guaranteeMap.get(guaranteeId);
    }
}