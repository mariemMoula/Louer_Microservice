package com.dari.louer_ms.repositories;

import com.dari.louer_ms.entities.TemporaryRental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemporaryRentalRepository extends JpaRepository<TemporaryRental, Long> {

    // Trouver les locations temporaires par propertyId et date
    List<TemporaryRental> findByPropertyIdAndStartDateBeforeAndEndDateAfter(
            String propertyId, String startDate, String endDate);
}