package com.example.races.controller;

import com.example.races.dto.DriverData;
import com.example.races.service.RacesDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("ranking")
public class RacesDataController {
    /*connecting with RacesDataService*/
    @Autowired
    RacesDataService racesDataService;

    @GetMapping
    public List<DriverData> getRanking() {return this.racesDataService.getRanking();}

    @GetMapping("/races")
    public List<DriverData> getRacesRanking(@RequestParam(required = false, defaultValue = "") String Race) {
        return this.racesDataService.getRacesRanking(Race);
    }
}
