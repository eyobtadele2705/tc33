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
public class PassengerTransport {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String ancillaryTicketDocumentNumber;
    String ancillaryCreditReasonIndicator;
    String ancillaryServiceCategory1;
    String ancillaryServiceSubCategory1;
    String ancillaryServiceCategory2;
    String ancillaryServiceSubCategory2;
    String ancillaryServiceCategory3;
    String ancillaryServiceSubCategory3;
    String ancillaryServiceCategory4;
    String ancillaryServiceSubCategory4;
    String ancillaryPassengerName;
    String issuedInConnectionWithTicketNumber;
    String reserved;
}
