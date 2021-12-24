package com.blooddonar.blooddonation.model;

import javax.persistence.*;

@Entity
@Table(name = "donor")
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int  id;
    private String name;
    private int age;
    private String address;
    private String bloodgrp;

    public Donor() {
    }

    public Donor(String name, int age, String address, String bloodgrp) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.bloodgrp = bloodgrp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodgrp() {
        return bloodgrp;
    }

    public void setBloodgrp(String bloodgrp) {
        this.bloodgrp = bloodgrp;
    }
}
