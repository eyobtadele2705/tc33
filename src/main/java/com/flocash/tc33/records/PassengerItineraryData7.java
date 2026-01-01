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
public class PassengerItineraryData7 {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String issuingCarrier;
    String ticketType;
    String documentType;
    String ticketingCarrierName;
    String ticketIssueCity;
    String ticketIssueDate;
    String numberInParty;
    String electronicTicketIndicator;
    String planNumber;
    String arrivalDateOverall;
    String restrictionIndicatorText;
    String exchangeAmountSummary;
    String exchangeFeeSummary;
    String reserved;
}
