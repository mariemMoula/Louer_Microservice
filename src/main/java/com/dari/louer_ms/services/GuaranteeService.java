package com.dari.louer_ms.services;

import com.dari.louer_ms.entities.Guarantee;
import com.dari.louer_ms.repositories.GuaranteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuaranteeService {

    @Autowired
    private GuaranteeRepository guaranteeRepository;

    // Déposer une garantie
    public Guarantee depositGuarantee(Guarantee guarantee) {
        return guaranteeRepository.save(guarantee);
    }

    // Trouver les garanties par propertyId
    public List<Guarantee> findGuaranteesByPropertyId(String propertyId) {
        return guaranteeRepository.findByPropertyId(propertyId);
    }
}