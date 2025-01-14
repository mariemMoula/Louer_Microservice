package com.dari.louer_ms.services;


import com.dari.louer_ms.entities.Property;
import com.dari.louer_ms.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    // Création d'une propriété
    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    // Mise à jour d'une propriété
    public Property updateProperty(Property property) {
        return propertyRepository.save(property);
    }

    // Recherche de propriétés par critères
    public List<Property> searchProperties(String location, int size, double price) {
        return propertyRepository.findByLocationContainingAndSizeGreaterThanAndPriceLessThan(location, size, price);
    }
}