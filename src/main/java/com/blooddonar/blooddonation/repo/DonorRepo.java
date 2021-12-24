package com.blooddonar.blooddonation.repo;

import com.blooddonar.blooddonation.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRepo extends JpaRepository<Donor,Integer>{
    public List<Donor> getByName(String name);
    public List<Donor> getByaddress(String address);
    public List<Donor> getBybloodgrp(String bloodgrp);
    public List<Donor> getByage(int age);



}
