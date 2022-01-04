package com.blooddonar.blooddonation.controller;

import com.blooddonar.blooddonation.DonorException.EmptyDataException;
import com.blooddonar.blooddonation.DonorException.NotFoundException;
import com.blooddonar.blooddonation.model.Donor;
import com.blooddonar.blooddonation.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donor")
public class DonorController {

   @Autowired
   private DonorService donorService;

   //   create a new donor or insert data into dbs
   @PostMapping("/register")
   public ResponseEntity<Donor> register(@RequestBody Donor donor){
      if (donor.getName()==""|| donor.getBloodgrp()=="" ||donor.getContact()== ""){
         throw new EmptyDataException("please provide all data");
      }
      Donor donorSaved = donorService.register(donor);

      return new ResponseEntity<Donor>(donorSaved, HttpStatus.CREATED);
   }
   //get list of donors
   @GetMapping("/getall")
   public ResponseEntity<List<Donor>> getall(){
      List<Donor> allDonors= donorService.getall();
      if (allDonors.isEmpty()){
         throw new NotFoundException("No user exists");
      }
      return new ResponseEntity<List<Donor>>(allDonors,HttpStatus.OK);
   }
   @PutMapping("/update/{id}")
   public ResponseEntity<Donor> update(@PathVariable int id ,@RequestBody Donor donor){
      Donor upadteddonor= donorService.update(id , donor);
      if(upadteddonor==null){
         throw new NotFoundException("No user exist with id" + id);
      }
      return new ResponseEntity<Donor>(upadteddonor,HttpStatus.OK);
   }

//   public ResponseEntity<> delete(@PathVariable int id){
//      Donor tobedeleted = donorService.delete(id);
//   }

   @GetMapping("/byname")
   public ResponseEntity<List<Donor>> getbyname(@PathVariable String name){
      List<Donor> donor=  donorService.getByName(name);
      if (donor.isEmpty()){
         throw  new NotFoundException("not found any user with such name" + name);
      }
      return new ResponseEntity<List<Donor>>(donor, HttpStatus.OK);
   }

   @GetMapping("/byage/{age}")
   public ResponseEntity<List<Donor>> getbyage(@PathVariable int age){
      List<Donor> donor=  donorService.getByage(age);
      if (donor.isEmpty()){
         throw  new NotFoundException("not found any user with such age " +age);
      }
      return new ResponseEntity<List<Donor>>(donor, HttpStatus.OK);
   }

   @GetMapping("/byaddress/{address}")
   public ResponseEntity<List<Donor>> getbyaddress(@PathVariable String address){
      List<Donor> donor=  donorService.getByaddress(address);
      if (donor.isEmpty()){
         throw  new NotFoundException("not found any user with such address " + address);
      }
      return new ResponseEntity<List<Donor>>(donor, HttpStatus.OK);
   }
   @GetMapping("/bybloodgrp/{bloodgrp}")
   public ResponseEntity<List<Donor>> getbybloodgrp(@PathVariable String bloodgrp){
      List<Donor> donor=  donorService.getByBloodgrp(bloodgrp);
      if (donor.isEmpty()){
         throw  new NotFoundException("not found any user with such Blood group " + bloodgrp);
      }
      return new ResponseEntity<List<Donor>>(donor, HttpStatus.OK);
   }
}
