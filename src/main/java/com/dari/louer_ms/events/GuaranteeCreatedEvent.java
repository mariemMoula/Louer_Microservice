package com.dari.louer_ms.events;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuaranteeCreatedEvent {
    private String guaranteeId;
    private String userId;
    private String documentUrl;
    private String propertyId;
}