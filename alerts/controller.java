package com.finpulse.controller;

import com.finpulse.model.Alert;
import com.finpulse.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @GetMapping("/{sector}")
    public List<Alert> getAlertsBySector(@PathVariable String sector) {
        return alertService.getAlertsBySector(sector);
    }

    @PostMapping
    public Alert createAlert(@RequestBody Alert alert) {
        return alertService.saveAlert(alert);
    }
}
