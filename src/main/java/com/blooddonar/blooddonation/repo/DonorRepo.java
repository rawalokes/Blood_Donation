package com.blooddonar.blooddonation.repo;

import com.blooddonar.blooddonation.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRepo extends JpaRepository<Donor,Integer>{
//    public List<Donor> getByName(String name);
//    public List<Donor> getByaddress(String address);
//    public List<Donor> getBybloodgrp(String bloodgrp);
//    public List<Donor> getByage(int age);

    @Query("select d FROM Donor d")
    public List<Donor> getall();

    @Query("select d from Donor d WHERE d.name=:n")
    public List<Donor> getByName(@Param("n") String name);

    @Query("select d from Donor d WHERE d.address=:a")
    public List<Donor> getByaddress(@Param("a") String address);

    @Query("select d from Donor d WHERE d.bloodgrp=:bg")
    public List<Donor> getBybloodgrp(@Param("bg") String bloodgrp);
    @Query("select  d from Donor d WHERE d.age=:a")
    public List<Donor> getByage(@Param("a") int age);
    

}
