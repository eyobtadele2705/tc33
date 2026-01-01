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
public class PassengerItineraryData5 {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String tripLeg3Information;
    String carrierCode;
    String serviceClass;
    String stopOverCode;
    String destinationCityAirport;
    String fareBasisCode_Leg3;
    String flightNumber_Leg3;
    String departureDate_Leg3;
    String departureTime_Leg3;
    String departureTimeSegment_Leg3;
    String arrivalTime_Leg3;
    String arrivalTimeSegment_Leg3;
    String endorsementRestrictions_Leg3;
    String conjunctionTicket_Leg3;
    String exchangeTicket_Leg3;
    String couponNumber_Leg3;
    String fareAmount_Leg3;
    String taxAmount_Leg3;
    String feeAmount_Leg3;
    String reserved;
}
