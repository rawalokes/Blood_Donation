package com.blooddonar.blooddonation.serviceManager;

import com.blooddonar.blooddonation.NotFoundException.NotFoundException;
import com.blooddonar.blooddonation.model.Donor;
import com.blooddonar.blooddonation.repo.DonorRepo;
import com.blooddonar.blooddonation.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DonorServiceManger implements DonorService {
    @Autowired
    private DonorRepo donorRepo;

    @Override
    public Donor register(Donor donor) {
        return donorRepo.save(donor);
    }

    @Override
    public List<Donor> getall() {

        return  donorRepo.findAll();
    }

    @Override
    public ResponseEntity<List<Donor>> getByName(String name) {
        List<Donor> donors= donorRepo.getByName(name);
        if(donors == null){
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return  ResponseEntity.ok(donors);
    }

    @Override
    public ResponseEntity<List<Donor>> getByage(int age) {
        List<Donor> donors=donorRepo.getByage(age);
        if (donors == null){
            throw new NotFoundException("invalid age");
        }
        return ResponseEntity.ok(donors);
    }

    @Override
    public ResponseEntity<List<Donor>> getByaddress(String address) {
        List <Donor> donors= donorRepo.getByaddress(address);
        if (donors==null){
            throw new NotFoundException("Not found");
        }

        return ResponseEntity.ok(donors);
    }

    @Override
    public ResponseEntity<List<Donor>> getByBloodgrp(String bloodgrp)
        {
        List<Donor> donors= donorRepo.getBybloodgrp(bloodgrp);
        if(donors==null){
            throw new NotFoundException("Not Found");
        }

        return ResponseEntity.ok(donors);
    }

    @Override
    public Donor update(int id,Donor donor) {
        Donor donor1 = donorRepo.findById(id).orElseThrow(() ->new NotFoundException("invalid"));
        donor1.setName(donor.getName());
        donor1.setAddress(donor.getAddress());
        donor1.setAge(donor.getAge());
        donor1.setBloodgrp(donor.getBloodgrp());
        return donorRepo.save(donor1);

    }
}
