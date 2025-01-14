package com.dari.louer_ms.services;

import com.dari.louer_ms.entities.TemporaryRental;
import com.dari.louer_ms.repositories.TemporaryRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    @Autowired
    private TemporaryRentalRepository rentalRepository;

    // Créer une location temporaire
    public TemporaryRental createTemporaryRental(TemporaryRental rental) {
        return rentalRepository.save(rental);
    }

    // Trouver des locations temporaires par propertyId et date
    public List<TemporaryRental> findRentals(String propertyId, String startDate, String endDate) {
        return rentalRepository.findByPropertyIdAndStartDateBeforeAndEndDateAfter(propertyId, startDate, endDate);
    }
}