package com.example.races.service;

import com.example.races.model.Driver;
import com.example.races.model.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Raceservice {
    /*connecting with the DriverService*/
    @Autowired
    DriverService driverService;
    /*methods for the other services*/
    public List<String> getRaces() {
        List<Driver> driverList = this.driverService.getAllDrivers();
        Driver driver = driverList.get(0);
        List<Race> races = driver.getRaces();
        List<String> nameRaces = new ArrayList<>();

        for(int i = 0; i < races.size(); i++) {
            nameRaces.add(races.get(i).getName());
        }

        nameRaces.add(0,"Global");
        return nameRaces;
    }
}
