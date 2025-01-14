package com.dari.louer_ms.repositories;

import com.dari.louer_ms.entities.Guarantee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuaranteeRepository extends JpaRepository<Guarantee, Long> {

    // Trouver une garantie par propertyId
    List<Guarantee> findByPropertyId(String propertyId);
}