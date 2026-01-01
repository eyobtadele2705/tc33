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
public class PassengerItineraryData4 {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String tripLeg2Information;
    String carrierCode;
    String serviceClass;
    String stopOverCode;
    String destinationCityAirport;
    String fareBasisCode_Leg2;
    String flightNumber_Leg2;
    String departureDate_Leg2;
    String departureTime_Leg2;
    String departureTimeSegment_Leg2;
    String arrivalTime_Leg2;
    String arrivalTimeSegment_Leg2;
    String endorsementRestrictions_Leg2;
    String conjunctionTicket_Leg2;
    String exchangeTicket_Leg2;
    String couponNumber_Leg2;
    String fareAmount_Leg2;
    String taxAmount_Leg2;
    String feeAmount_Leg2;
    String reserved;
}
