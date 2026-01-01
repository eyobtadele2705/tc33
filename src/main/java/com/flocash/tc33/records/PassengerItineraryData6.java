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
public class PassengerItineraryData6 {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String groupTripLeg4Information;
    String carrierCode;
    String serviceClass;
    String stopOverCode;
    String destinationCityAirport;
    String fareBasisCode_Leg4;
    String flightNumber_Leg4;
    String departureDate_Leg4;
    String departureTime_Leg4;
    String departureTimeSegment_Leg4;
    String arrivalTime_Leg4;
    String arrivalTimeSegment_Leg4;
    String endorsementRestrictions_Leg4;
    String conjunctionTicket_Leg4;
    String exchangeTicket_Leg4;
    String couponNumber_Leg4;
    String fareAmount_Leg4;
    String taxAmount_Leg4;
    String feeAmount_Leg4;
    String reserved;
}
