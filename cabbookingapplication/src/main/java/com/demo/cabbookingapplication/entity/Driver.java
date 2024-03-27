package com.demo.cabbookingapplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer driverId;
    private String licenceNo;
    private float rating;
    private String currLocation;
    private String currDriverStatus;
    private String driverName;

    private String address;

    private String mobileNumber;

    private String email;

    private String userRole;

    @OneToOne
    @JsonIgnore
    private Cab cab;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "driver")
    @JsonIgnore
    @JsonBackReference
    List<TripBooking> trips = new ArrayList<>();
}
