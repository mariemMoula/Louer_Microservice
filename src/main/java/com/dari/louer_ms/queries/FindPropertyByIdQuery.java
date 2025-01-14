package com.dari.louer_ms.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindPropertyByIdQuery {
    private String propertyId;
}