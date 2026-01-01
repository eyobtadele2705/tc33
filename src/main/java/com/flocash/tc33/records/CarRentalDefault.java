package com.flocash.tc33.records;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class CarRentalDefault {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String destinationIdentifier;
    String sourceIdentifier;
    String tc33ApplicationCode;
    String messageIdentifier;
    String renterName;
    String carRentalCheckOutDate;
    String insuranceCharges;
    String carClassCode;
    String oneWayDropOffCharges;
    String carRentalNoShowIndicator;
    String daysRented;
    String adjustmentAmountIndicatorCode;
    String adjustedAmount;
    String fuelCharges;
    String timePeriod;
    String weeklyRentalRate;
    String milesKilometerIndicator;
    String reserved;

    CarRentalDefault2 carRentalDefault2;
    CarRentalDefault3 carRentalDefault3;
    CarRentalDefault4 carRentalDefault4;
    CarRentalDefault5 carRentalDefault5;

}
