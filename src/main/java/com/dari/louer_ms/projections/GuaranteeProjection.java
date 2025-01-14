package com.dari.louer_ms.projections;

import com.dari.louer_ms.entities.Guarantee;
import com.dari.louer_ms.events.GuaranteeCreatedEvent;
import com.dari.louer_ms.repositories.GuaranteeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class GuaranteeProjection {

    private final GuaranteeRepository guaranteeRepository;

    public GuaranteeProjection(GuaranteeRepository guaranteeRepository) {
        this.guaranteeRepository = guaranteeRepository;
    }

    @EventHandler
    public void on(GuaranteeCreatedEvent event) {
        Guarantee guarantee = new Guarantee();
        guarantee.setGuaranteeId(event.getGuaranteeId());
        guarantee.setUserId(event.getUserId());
        guarantee.setDocumentUrl(event.getDocumentUrl());
        guaranteeRepository.save(guarantee);
    }
}