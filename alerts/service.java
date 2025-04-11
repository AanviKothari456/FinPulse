package com.finpulse.service;

import com.finpulse.model.Alert;
import com.finpulse.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    public List<Alert> getAlertsBySector(String sector) {
        return alertRepository.findBySectorIgnoreCase(sector);
    }

    public Alert saveAlert(Alert alert) {
        return alertRepository.save(alert);
    }
}