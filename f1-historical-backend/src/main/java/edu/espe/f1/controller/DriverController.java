package edu.espe.f1.controller;

import edu.espe.f1.entity.Driver;
import edu.espe.f1.service.DriverService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
@CrossOrigin(origins = "*")
public class DriverController {

    @Autowired
    private DriverService driverService;

    // 1. OBTENER TODOS LOS PILOTOS
    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers() {
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    // 2. OBTENER UN PILOTO POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable String id) {
        return ResponseEntity.ok(driverService.getDriverById(id));
    }

    // 3. REGISTRAR NUEVO PILOTO (Envía 201 Created)
    @PostMapping
    public ResponseEntity<Driver> createDriver(@Valid @RequestBody Driver driver) {
        return new ResponseEntity<>(driverService.createDriver(driver), HttpStatus.CREATED);
    }

    // 4. ACTUALIZAR PILOTO EXISTENTE
    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable String id, @Valid @RequestBody Driver driverDetails) {
        return ResponseEntity.ok(driverService.updateDriver(id, driverDetails));
    }

    // 5. ELIMINAR UN PILOTO (Envía 204 No Content)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable String id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }
}