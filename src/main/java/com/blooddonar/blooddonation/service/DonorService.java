package com.blooddonar.blooddonation.service;

import com.blooddonar.blooddonation.model.Donor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
public interface DonorService {
    public Donor register(Donor donor);
    public List<Donor> getall();
    public Donor update(int id,Donor donor);
    public List<Donor> getByName(String name);
    public List<Donor> getByage(int age);
    public List<Donor> getByaddress(String address);
    public List<Donor> getByBloodgrp(String bloodgrp);
    public void delete(int id);


}
