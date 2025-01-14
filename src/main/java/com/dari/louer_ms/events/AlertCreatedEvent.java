package com.dari.louer_ms.events;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlertCreatedEvent {
    private String alertId;
    private String userId;
    private String criteria;
}
