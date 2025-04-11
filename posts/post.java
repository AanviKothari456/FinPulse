package com.finpulse.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @ElementCollection
    private List<String> watchlist; // List of sector names

    public User() {}

    // Getters and setters omitted for brevity
}