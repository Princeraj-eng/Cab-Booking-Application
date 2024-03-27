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
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cabId;
    private String carType;
    private String carName;
    private String carNumber;
    private float perKmRate;
    private String SourceLocation;
    private String DestinationLocation;
    private String cabCurrStatus;

    @OneToOne
    @JsonIgnore
    private Driver driver;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "cab")
    @JsonIgnore
    @JsonBackReference
    List<TripBooking> trips = new ArrayList<>();




    public Integer getCabId() {
        return cabId;
    }

    public void setCabId(Integer cabId) {
        this.cabId = cabId;
    }

    public String getSourceLocation() {
        return SourceLocation;
    }

    public void setSourceLocation(String sourceLocation) {
        SourceLocation = sourceLocation;
    }

    public String getDestinationLocation() {
        return DestinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        DestinationLocation = destinationLocation;
    }
}
