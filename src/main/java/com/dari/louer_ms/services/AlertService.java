package com.dari.louer_ms.services;

import com.dari.louer_ms.entities.Alert;
import com.dari.louer_ms.repositories.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    // Créer une alerte pour un utilisateur
    public Alert createAlert(Alert alert) {
        return alertRepository.save(alert);
    }

    // Mettre à jour l'état de l'alerte
    public Alert updateAlert(Alert alert) {
        return alertRepository.save(alert);
    }

    // Trouver les alertes actives d'un utilisateur
    public List<Alert> findActiveAlerts(String userId) {
        return alertRepository.findByUserIdAndIsActive(userId, true);
    }
}
