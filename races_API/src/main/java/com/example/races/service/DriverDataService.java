package com.example.races.service;

import com.example.races.dto.DriverData;
import com.example.races.dto.RaceData;
import com.example.races.model.Driver;
import com.example.races.model.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DriverDataService {
    /*connecting with services*/
    @Autowired
    DriverService driverService;
    @Autowired
    RacesDataService racesDataService;

    /*logic starts*/
    public DriverData getDriver(String id) {
        /*global list to compare*/
        List<Driver> driverList = this.driverService.getAllDrivers();
        /*get the driver*/
        Optional<Driver> optionalDriver = this.driverService.getDriver(id);
        Driver driver = new Driver();
        DriverData driverData = new DriverData();
        /*if statement to verify we have the driver and proceed to adding new fields to the new array*/
        if(optionalDriver.isEmpty()) {
            return null;
        } else {
            driver = optionalDriver.get();
            /*add necessary fields*/
            driverData.setId(driver.getId());
            driverData.setPicture(driver.getPicture());
            driverData.setName(driver.getName());
            driverData.setTeam(driver.getTeam());
            driverData.setAge(driver.getAge());

            /*obtain global ranking*/
            List<DriverData> globalList = this.racesDataService.getRanking();
            /*initialize position*/
            Integer position = 0;
            /*obtain driver by id*/
            for (int i=0; i<globalList.size(); i++) {
                if (globalList.get(i).getId().equals(id)) {
                    position = i + 1;
                }
            }
            /*add position field*/
            driverData.setPosition(position);
            /*add races array with position*/
            List<RaceData> raceDataList = new ArrayList<>();
            for (Race race :driver.getRaces()){
                RaceData raceData = new RaceData();
                raceData.setName(race.getName());
                raceData.setTime(race.getTime());
                /*initialize position*/
                Integer rposition = 0;
                /*funtion*/
                rposition = this.getDriverPosition(id, race.getName(), driverList);
                raceData.setPosition(rposition);
                raceDataList.add(raceData);
            }
            driverData.setRaces(raceDataList);
        }
        return driverData;
    }

    private Integer getDriverPosition(String id, String Race, List<Driver> driverList) {
        /*obtain driver index*/
        List<DriverData> driverDataList = new ArrayList<>();
        for (Driver driver :driverList) {
            DriverData driverData = new DriverData();
            float rtime = 0;
            for (Race race :driver.getRaces()) {
                if(race.getName().equalsIgnoreCase(Race)) {
                    String[] data = race.getTime().split(":");
                    int hours = (Integer.parseInt(data[0]))*3600;
                    int minutes = (Integer.parseInt(data[1]))*60;
                    float seconds = Float.parseFloat(data[2]);
                    float sec;
                    sec = seconds + minutes + hours;
                    rtime = rtime + sec;

                    /*adding necessary fields*/
                    driverData.setId(driver.getId());
                    driverData.setTime(rtime);

                    driverDataList.add(driverData);
                }
            }
        }
        /*sort list by time*/
        driverDataList.sort(Comparator.comparing(DriverData::getTime));
        /*initialize position*/
        Integer position = 0;
        for (int i = 0; i < driverDataList.size(); i++) {
            if (driverDataList.get(i).getId().equals(id)){
                position = i + 1;
            }
        }
        return position;
    }
}
