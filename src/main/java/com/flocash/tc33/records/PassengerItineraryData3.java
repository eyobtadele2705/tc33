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
public class PassengerItineraryData3 {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String tripLeg1Information;
    String carrierCode;
    String serviceClass;
    String stopOverCode;
    String destinationCityAirport;
    String fareBasisCode_Leg1;
    String flightNumber_Leg1;
    String departureDate_Leg1;
    String departureTime_Leg1;
    String departureTimeSegment_Leg1;
    String arrivalTime_Leg1;
    String arrivalTimeSegment_Leg1;
    String endorsementRestrictions_Leg1;
    String conjunctionTicket_Leg1;
    String exchangeTicket_Leg1;
    String couponNumber_Leg1;
    String fareAmount_Leg1;
    String taxAmount_Leg1;
    String feeAmount_Leg1;
    String reserved;
}
