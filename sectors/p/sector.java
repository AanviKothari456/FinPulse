package com.finpulse.controller;

import com.finpulse.model.Sector;
import com.finpulse.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sectors")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping
    public List<Sector> getAllSectors() {
        return sectorService.getAllSectors();
    }

    @PostMapping
    public Sector addSector(@RequestBody Sector sector) {
        return sectorService.saveSector(sector);
    }
}