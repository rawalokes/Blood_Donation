package com.blooddonar.blooddonation.controller;

import com.blooddonar.blooddonation.model.Donor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.blooddonar.blooddonation.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/donor")
public class DonorController {
    @Autowired
    private DonorService donorService;

//    GET ALL DONOR
    @GetMapping("/getall")
    public List<Donor> getall(){
       return donorService.getall();
    }

//    REGISTER DONOR
    @PostMapping("register")
    public  Donor register(@RequestBody Donor donor){
        return donorService.register(donor);
    }
//Update existing user by using ID
    @PutMapping("/update/{id}")
    public Donor updateDonor(@PathVariable int id ,@RequestBody Donor donor){
        return donorService.update(id, donor);
    }

    //Search using name
    @GetMapping("/byname/{name}")
    public ResponseEntity <List<Donor>> getByName(@PathVariable String name){
        return donorService.getByName(name);
    }
    //Serch using address
    @GetMapping("/byaddress/{address}")
    public  ResponseEntity<List<Donor>> getByAddress(@PathVariable String address){
        return donorService.getByaddress(address);
    }
    //Serch using address
    @GetMapping("/byage/{age}")
    public  ResponseEntity<List<Donor>> getByAge(@PathVariable int age){
        return donorService.getByage(age);
    }
    //Serch using blood Group
    @GetMapping("/bybloodgrp/{bg}")
    public  ResponseEntity<List<Donor>> getByBloodGrp(@PathVariable String bloodgrp){
        return donorService.getByBloodgrp(bloodgrp);
    }



}
