package com.dari.louer_ms.repositories;

import com.dari.louer_ms.entities.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Long> {

    // Trouver les alertes actives pour un utilisateur
    List<Alert> findByUserIdAndIsActive(String userId, boolean isActive);
}
