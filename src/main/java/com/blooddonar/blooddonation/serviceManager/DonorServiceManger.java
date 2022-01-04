package com.blooddonar.blooddonation.serviceManager;

import com.blooddonar.blooddonation.DonorException.NotFoundException;
import com.blooddonar.blooddonation.model.Donor;
import com.blooddonar.blooddonation.repo.DonorRepo;
import com.blooddonar.blooddonation.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DonorServiceManger implements DonorService {
    @Autowired
    private DonorRepo donorRepo;
//   create a new donor or insert data into dbs
    @Override
    public Donor register(Donor donor) {
        return donorRepo.save(donor);
    }
    //get list of donors
    @Override
    public List<Donor> getall() {
        return donorRepo.findAll();
    }

    @Override
    public Donor update(int id, Donor donor) {
        Donor donor1= donorRepo.findById(id).orElseThrow(()-> new NotFoundException("not found"));
        donor1.setName(donor.getName());
        donor1.setAddress(donor.getAddress());
        donor1.setBloodgrp(donor.getBloodgrp());
        donor1.setAge(donor.getAge());
        return donorRepo.save(donor1);
    }
//search users using name it returns list of user by name
    @Override
    public List<Donor> getByName(String name) {
        return donorRepo.getByName(name);
    }
    //search users using age it returns list of user by age
    @Override
    public List<Donor> getByage(int age) {
        return donorRepo.getByage(age);
    }
    //search users using address it returns list of user by address
    @Override
    public List<Donor> getByaddress(String address) {
        return donorRepo.getByaddress(address);
    }
    //search users using blood group it returns list of user by group
    @Override
    public List<Donor> getByBloodgrp(String bloodgrp) {
        return donorRepo.getBybloodgrp(bloodgrp);
    }

    @Override
    public void delete(int id) {
        Donor tobedeleted=donorRepo.findById(id).orElseThrow(()->new NotFoundException("invalid id"));
        donorRepo.delete(tobedeleted);
    }
}