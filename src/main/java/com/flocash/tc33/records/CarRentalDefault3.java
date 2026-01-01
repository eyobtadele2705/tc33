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
public class CarRentalDefault3 {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String totalTaxAmount;
    String taxAmountSign;
    String odometer;
    String vehicleIdentificationNumber;
    String commodityCode;
    String taxExemptIndicator;
    String corporateIdentifier;
    String regularMileageCharge;
    String extraMileageCharge;
    String lateCharge;
    String totalTaxCollectedIndicator;
    String ratePerMileOrPerKilometer;
    String maximumFreeMilesOrKilometers;
    String vehicleInsuranceIndicator;
    String programCode;
    String otherCharges;
    String autoRentalPickUpTime;
    String autoRentalReturnTime;
    String dailyRentalRate;
    String reserved;
}
