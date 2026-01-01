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
public class CarRentalDefault5 {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String coupon;
    String additionalCoupon;
    String totalAmount;
    String phoneCharge;
    String gpsCharge;
    String pickupLocation;
    String driverIdentificationNumber;
    String driverTaxNumber;
    String corporateClientCode;
    String customerServiceTollFree800Number;
    String reserved;
}
