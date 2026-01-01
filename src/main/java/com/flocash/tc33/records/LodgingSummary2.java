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
public class LodgingSummary2 {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String dailyRoomRate2;
    String dailyRoomNights2;
    String dailyRoomRate3;
    String dailyRoomNights3;
    String guestName;
    String reserved;
}
