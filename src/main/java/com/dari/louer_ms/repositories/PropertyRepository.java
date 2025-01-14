package com.dari.louer_ms.repositories;

import com.dari.louer_ms.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, String> {

    // Recherche de propriétés par localisation, taille ou prix
    List<Property> findByLocationContainingAndSizeGreaterThanAndPriceLessThan(
            String location, Integer size, Double price);
}