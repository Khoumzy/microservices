package com.mak.clockin.controllers;

import com.mak.clockin.controllers.vm.ClockinWrapper;
import com.mak.clockin.models.Clockin;
import com.mak.clockin.repositories.ClockinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("v0/clockins")
public class ClockinController {

    @Autowired
    private ClockinRepository clockinRepository;

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<List<Clockin>> getClockin(@PathVariable int id){

        return ResponseEntity.ok(clockinRepository.findAllByUserId(id));
    }

    @PostMapping(value = "")
    public ResponseEntity clockIn(@RequestBody ClockinWrapper clockinWrapper){
        Clockin clockin = new Clockin();
        clockin.setUserId(clockinWrapper.getUserId());
        clockin.setHeure(Instant.now());

        clockinRepository.save(clockin);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
