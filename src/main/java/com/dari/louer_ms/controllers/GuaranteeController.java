package com.dari.louer_ms.controllers;
import com.dari.louer_ms.entities.Guarantee;
import com.dari.louer_ms.services.GuaranteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/guarantees")
public class GuaranteeController {

    @Autowired
    private GuaranteeService guaranteeService;

    // Déposer une garantie
    @PostMapping
    public Guarantee depositGuarantee(@RequestBody Guarantee guarantee) {
        return guaranteeService.depositGuarantee(guarantee);
    }

    // Trouver une garantie par propertyId
    @GetMapping("/property/{propertyId}")
    public List<Guarantee> findGuaranteesByPropertyId(@PathVariable String propertyId) {
        return guaranteeService.findGuaranteesByPropertyId(propertyId);
    }
}
