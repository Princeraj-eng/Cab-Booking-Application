package com.demo.cabbookingapplication.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideDTO {

    private Integer cabId;
    private String carType;
    private String carName;
    private String carNumber;
    private String SourceLocation;
    private String DestinationLocation;
    private Integer driverId;
    private String licenceNo;
    private float rating;
    private String currLocation;
    private String currDriverStatus;
    private String driverName;

}
