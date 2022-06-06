package com.example.races.service;

import com.example.races.model.Driver;
import com.example.races.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    /*connecting with the repository*/
    @Autowired
    DriverRepository driverRepository;
    /*methods for the other services*/
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }
    public Optional<Driver> getDriver(String id) {
        return driverRepository.findById(id);
    }
}
