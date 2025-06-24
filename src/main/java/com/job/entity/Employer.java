package com.job.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String companyName;
    private String email;

    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "postedByEmployer", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("postedByEmployer")  // Prevent circular reference
    private List<Job> jobs;
}
