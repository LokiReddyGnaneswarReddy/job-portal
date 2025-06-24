package com.job.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private String companyName;
    private String location;
    private String salary;

    @ManyToOne
    @JoinColumn(name = "employer_id")  // DB column is employer_id
    @JsonIgnoreProperties("jobs")      // Prevent JSON infinite loop
    private Employer postedByEmployer;
}