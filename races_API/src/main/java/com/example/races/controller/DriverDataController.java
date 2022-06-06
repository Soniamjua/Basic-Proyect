package com.example.races.controller;

import com.example.races.dto.DriverData;
import com.example.races.service.DriverDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("driver")
public class DriverDataController {
    /*connecting with service*/
    @Autowired
    DriverDataService driverDataService;

    /*endpoint*/
    @GetMapping(value = "/{id}")
    public DriverData getId(@PathVariable String id) {
        return this.driverDataService.getDriver(id);
    }
}
