package edu.espe.f1.service;

import edu.espe.f1.entity.Driver;
import edu.espe.f1.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver getDriverById(String id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Piloto no encontrado con ID: " + id));
    }

    public Driver createDriver(Driver driver) {
        if (driverRepository.existsById(driver.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El piloto ya existe con el ID: " + driver.getId());
        }
        return driverRepository.save(driver);
    }

    public Driver updateDriver(String id, Driver driverDetails) {
        Driver driver = getDriverById(id);
        driver.setName(driverDetails.getName());
        driver.setSlug(driverDetails.getSlug());
        driver.setNationality(driverDetails.getNationality());
        driver.setBorn(driverDetails.getBorn());
        driver.setNumber(driverDetails.getNumber());
        driver.setChampionships(driverDetails.getChampionships());
        driver.setWins(driverDetails.getWins());
        driver.setPodiums(driverDetails.getPodiums());
        driver.setPoles(driverDetails.getPoles());
        driver.setPoints(driverDetails.getPoints());
        driver.setBio(driverDetails.getBio());
        driver.setCurrentTeam(driverDetails.getCurrentTeam());
        return driverRepository.save(driver);
    }

    public void deleteDriver(String id) {
        Driver driver = getDriverById(id);
        driverRepository.delete(driver);
    }
}