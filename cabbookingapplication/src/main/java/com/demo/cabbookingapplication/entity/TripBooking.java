package com.demo.cabbookingapplication.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TripBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tripBookingId;
    @NotNull
    private String pickupLocation;
    @NotNull
    private String fromDateTime;
    @NotNull
    private String dropLocation;
    @NotNull
    private String toDateTime;
    @NotNull
    private float distanceInKm;
    @JsonIgnore
    private String currStatus;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonIgnore
    @JoinColumn
    @JsonBackReference
    private Driver driver;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonIgnore
    @JoinColumn
    @JsonBackReference
    private User user;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JsonIgnore
    @JoinColumn
    @JsonBackReference
    private Cab cab;
}
