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
public class CarRentalDefault4 {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String towingCharges;
    String extraCharges;
    String parkingViolationCharges;
    String additionalDrivers;
    String rentalAddress;
    String age;
    String specialProgramCode;
    String vehicleMake;
    String vehicleModel;
    String travelAgencyCode;
    String travelAgencyName;
    String taxType;
    String taxRate;
    String taxElements;
    String reserved;
}
