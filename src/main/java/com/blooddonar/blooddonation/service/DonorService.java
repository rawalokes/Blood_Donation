package com.blooddonar.blooddonation.service;

import com.blooddonar.blooddonation.model.Donor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface DonorService {
    public Donor register(Donor donor);
    public List<Donor> getall();
    public Donor update(int id,Donor donor);
    public ResponseEntity<List<Donor>> getByName(String name);
    public ResponseEntity<List<Donor>> getByage(int age);
    public ResponseEntity<List<Donor>> getByaddress(String address);
    public ResponseEntity<List<Donor>> getByBloodgrp(String bloodgrp);


}
