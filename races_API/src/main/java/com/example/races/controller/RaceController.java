package com.example.races.controller;

import com.example.races.service.Raceservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("races")
public class RaceController {
    /*connecting with RaceService*/
    @Autowired
    Raceservice raceservice;
    /*dropdown list of races*/
    @GetMapping("")
    public List<String> getRaces(){
        return this.raceservice.getRaces();
    }
}
