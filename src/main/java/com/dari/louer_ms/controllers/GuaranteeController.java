package com.dari.louer_ms.controllers;
import com.dari.louer_ms.entities.Guarantee;
import com.dari.louer_ms.services.GuaranteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/guarantees")
public class GuaranteeController {

    @Autowired
    private GuaranteeService guaranteeService;

    // Endpoint pour déposer une garantie
    @PostMapping
    public ResponseEntity<Guarantee> createGuarantee(@RequestBody Guarantee guarantee) {
        Guarantee savedGuarantee = guaranteeService.depositGuarantee(guarantee);
        return ResponseEntity.ok(savedGuarantee);
    }

    // Endpoint pour trouver des garanties par propertyId
    @GetMapping("/property/{propertyId}")
    public ResponseEntity<List<Guarantee>> getGuaranteesByPropertyId(@PathVariable String propertyId) {
        List<Guarantee> guarantees = guaranteeService.findGuaranteesByPropertyId(propertyId);
        if (guarantees.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(guarantees);
    }

    // Endpoint pour mettre à jour une garantie
    @PutMapping("/{guaranteeId}")
    public ResponseEntity<Guarantee> updateGuarantee(
            @PathVariable String guaranteeId,
            @RequestBody Guarantee updatedGuarantee) {
        Guarantee guarantee = guaranteeService.updateGuarantee(guaranteeId, updatedGuarantee);
        if (guarantee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(guarantee);
    }

    // Endpoint pour supprimer une garantie
    @DeleteMapping("/{guaranteeId}")
    public ResponseEntity<Void> deleteGuarantee(@PathVariable String guaranteeId) {
        boolean isDeleted = guaranteeService.deleteGuarantee(guaranteeId);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
