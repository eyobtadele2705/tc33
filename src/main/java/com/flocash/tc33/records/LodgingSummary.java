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
public class LodgingSummary {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String destinationIdentifier;
    String sourceIdentifier;
    String tc33ApplicationCode;
    String messageIdentifier;
    String checkInDate;
    String checkOutDate;
    String dailyRoomRate1;
    String dailyRoomNights1;
    String customerServiceTollFreeNumber;
    String specialProgramCode;
    String travelAgencyCode;
    String travelAgencyName;
    String roomServiceCharges;
    String miniBarCharges;
    String internetAccessCharges;
    String fireSafetyIndicator;
    String reserved;

    LodgingSummary2 lodgingSummary2;
    LodgingSummary3 lodgingSummary3;
    LodgingAdditionalAmounts lodgingAdditionalAmounts;
    LodgingAdditionalAmounts2 lodgingAdditionalAmounts2;

}
