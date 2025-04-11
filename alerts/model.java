package com.finpulse.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alerts")
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sector;
    private String message;
    private LocalDateTime timestamp;

    public Alert() {}

    public Alert(String sector, String message, LocalDateTime timestamp) {
        this.sector = sector;
        this.message = message;
        this.timestamp = timestamp;
    }
}