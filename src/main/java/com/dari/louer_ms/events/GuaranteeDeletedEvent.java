package com.dari.louer_ms.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GuaranteeDeletedEvent {
    private String guaranteeId;
}