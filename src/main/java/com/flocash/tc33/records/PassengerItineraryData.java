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
public class PassengerItineraryData {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String destinationIdentifier;
    String sourceIdentifier;
    String tc33ApplicationCode;
    String messageIdentifier;
    String passengerName;
    String departureDate;
    String originationCityAirportCode;
    String travelAgencyCode;
    String travelAgencyName;
    String restrictedTicketIndicator;
    String computerizedReservationSystem;
    String ticketNumber;
    String totalClearingAmount;
    String customerCode;
    String multipleClearingSequenceNumber;
    String multipleClearingSequenceCount;
    String reserved;

    PassengerItineraryData2 passengerItineraryData2;
    PassengerItineraryData3 passengerItineraryData3;
    PassengerItineraryData4 passengerItineraryData4;
    PassengerItineraryData5 passengerItineraryData5;
    PassengerItineraryData6 passengerItineraryData6;
    PassengerTransport passengerTransport;
    PassengerItineraryData7 passengerItineraryData7;




}
