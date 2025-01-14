package com.dari.louer_ms.controllers;


import com.dari.louer_ms.entities.Property;
import com.dari.louer_ms.services.PropertyService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    // Création d'une propriété
    @PostMapping
    public Property createProperty(@RequestBody Property property) {
        return propertyService.createProperty(property);
    }

    // Mise à jour d'une propriété
    @PutMapping
    public Property updateProperty(@RequestBody Property property) {
        return propertyService.updateProperty(property);
    }

    // Recherche de propriétés par critères
    @GetMapping("/search")
    @CircuitBreaker(name = "propertyCircuitBreaker", fallbackMethod = "fallbackSearchProperties")
    public List<Property> searchProperties(
            @RequestParam String location,
            @RequestParam int size,
            @RequestParam double price) {
        return propertyService.searchProperties(location, size, price);
    }

    // Méthode fallback pour le circuit breaker en cas d'échec
    public List<Property> fallbackSearchProperties(String location, int size, double price, Throwable ex) {
        return List.of(); // Retourne une liste vide si le circuit breaker est déclenché
    }
}