package com.dari.louer_ms.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindPropertiesByCriteriaQuery {
    private String location;
    private int size;
    private double price;
}