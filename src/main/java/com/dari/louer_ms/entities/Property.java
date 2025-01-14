package com.dari.louer_ms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    @Id
    private String propertyId;
    private String name;
    private String location;
    private Double price;
    private String propertyType;
    private String ownerId;
    private Integer size;
    private Boolean available;
}
