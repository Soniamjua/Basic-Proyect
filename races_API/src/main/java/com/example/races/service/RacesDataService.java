package com.example.races.service;

import com.example.races.dto.DriverData;
import com.example.races.model.Driver;
import com.example.races.model.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class RacesDataService {
    /*connecting with DriverService for the methods*/
    @Autowired
    DriverService driverService;
    /*starts logic*/
    public List<DriverData> getRanking() {
        List<Driver> driverList = this.driverService.getAllDrivers();
        return this.getData(driverList);
    }
    /*Global list ranking*/
    private List<DriverData> getData(List<Driver> driverList) {
        List<DriverData> driverDataList = new ArrayList<>();
        for (Driver driver :driverList) {
            DriverData driverData = new DriverData();
            /*initialize time variable*/
            float rtime = 0;
            /*convert string to float*/
            for (Race race :driver.getRaces()) {
                String[] data = race.getTime().split(":");
                int hours = (Integer.parseInt(data[0]))*3600;
                int minutes = (Integer.parseInt(data[1]))*60;
                float seconds = Float.parseFloat(data[2]);
                float sec;
                sec = seconds + minutes + hours;
                rtime = rtime + sec;
            }
            /*adding necessary fields to the new array*/
            driverData.setId(driver.getId());
            driverData.setPicture(driver.getPicture());
            driverData.setName(driver.getName());
            driverData.setTeam(driver.getTeam());
            driverData.setTime(rtime);
            driverDataList.add(driverData);
        }
        /*sort by time*/
        driverDataList.sort(Comparator.comparing(DriverData::getTime));

        for (DriverData driverData :driverDataList) {
            driverData.setTime(null);
        }
        return  driverDataList;
    }

    /*races list*/
    public List<DriverData> getRacesRanking(String Race) {
        List<Driver> driverList = this.driverService.getAllDrivers();
        List<DriverData> driverDataList = new ArrayList<>();
        for (Driver driver :driverList) {
            DriverData driverData = new DriverData();
            float rtime = 0;
            for (Race race :driver.getRaces()) {
                /*check race*/
                if (race.getName().equalsIgnoreCase(Race)) {
                    /*convert string to float*/
                    String[] data = race.getTime().split(":");
                    int hours = (Integer.parseInt(data[0]))*3600;
                    int minutes = (Integer.parseInt(data[1]))*60;
                    float seconds = Float.parseFloat(data[2]);
                    float sec;
                    sec = seconds + minutes + hours;
                    rtime = rtime + sec;

                    /*adding necessary fields*/
                    driverData.setName(driver.getName());
                    driverData.setPicture(driver.getPicture());
                    driverData.setTeam(driver.getTeam());
                    driverData.setTime(rtime);
                    driverDataList.add(driverData);
                }
            }
        }
        /*sort by time*/
        driverDataList.sort(Comparator.comparing(DriverData::getTime));
        for (DriverData driverData :driverDataList) {
            driverData.setTime(null);
        }
        return driverDataList;
    }
}
