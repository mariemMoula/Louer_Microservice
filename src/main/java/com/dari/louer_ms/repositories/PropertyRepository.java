package com.dari.louer_ms.repositories;

import com.dari.louer_ms.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    // Recherche de propriétés par localisation, taille ou prix
    List<Property> findByLocationContainingAndSizeGreaterThanAndPriceLessThan(
            String location, int size, double price);
}