package com.dari.louer_ms.events;

public class GuaranteeStatusUpdatedEvent {

    private final String guaranteeId;
    private final String status;

    public GuaranteeStatusUpdatedEvent(String guaranteeId, String status) {
        this.guaranteeId = guaranteeId;
        this.status = status;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public String getStatus() {
        return status;
    }
}