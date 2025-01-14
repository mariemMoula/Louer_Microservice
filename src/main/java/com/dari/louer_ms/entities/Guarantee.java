package com.dari.louer_ms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Guarantee {
    @Id
    private String guaranteeId;
    private String userId;
    private String documentUrl;
    private String propertyId;
}