package com.keyin.airline;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airline")
@CrossOrigin
public class AirlineController {
    @Autowired
    public AirlineService airlineService;

    @GetMapping
    public List<Airline> getAllAirline(){
        return (List<Airline>) airlineService.getAllAirline();
    }

    @GetMapping("/{id}")
    public  List<Airline> getAllAirlineById(Long id){
        return (List<Airline>) airlineService.getAllAirlineById(id);
    }

    @PostMapping
    public Airline addAirline(@RequestBody Airline airline){
        return airlineService.addAirline(airline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airline> updateAirline(@PathVariable long id, @RequestBody Airline airline){
        return ResponseEntity.ok((airlineService.updateAirline(id,airline)));
    }

    @DeleteMapping("/{id}")
    public void deleteAirline(@PathVariable long id){
        airlineService.deleteAirlineById(id);
    }



}
