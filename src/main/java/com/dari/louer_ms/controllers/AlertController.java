package com.dari.louer_ms.controllers;

import com.dari.louer_ms.entities.Alert;
import com.dari.louer_ms.services.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/alerts")
public class AlertController {

    @Autowired
    private AlertService alertService;

    // Créer une alerte
    @PostMapping
    public Alert createAlert(@RequestBody Alert alert) {
        return alertService.createAlert(alert);
    }

    // Mettre à jour l'état de l'alerte
    @PutMapping
    public Alert updateAlert(@RequestBody Alert alert) {
        return alertService.updateAlert(alert);
    }

    // Récupérer les alertes actives d'un utilisateur
    @GetMapping("/active/{userId}")
    public List<Alert> getActiveAlerts(@PathVariable String userId) {
        return alertService.findActiveAlerts(userId);
    }
}
