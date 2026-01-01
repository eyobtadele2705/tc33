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
public class LodgingAdditionalAmounts2 {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String healthClubCharges;
    String valetParkingCharges;
    String cashDisbursementCharges;
    String nonRoomCharges;
    String businessCenterCharges;
    String transportationCharges;
    String gratuityCharges;
    String conferenceRoomCharges;
    String audioVisualCharges;
    String banquetCharges;
    String totalNonRoomTaxAmount;
    String reserved;
}
