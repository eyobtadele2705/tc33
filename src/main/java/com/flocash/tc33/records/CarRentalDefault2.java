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
public class CarRentalDefault2 {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String rentalReturnStateProvince;
    String rentalReturnCountry;
    String rentalReturnDate;
    String rentalAgreement;
    String renterReturnCity;
    String rentalLocationCity;
    String rentalLocationStateProvince;
    String rentalLocationCountry;
    String totalMilesOrKilometers;
    String rentalLocationID;
    String rentalReturnLocationID;
    String returnDropOffLocation;
    String reserved;
}
