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
public class EMVData {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String destinationIdentifier;
    String sourceIdentifier;
    String tc33ApplicationCode;
    String messageIdentifier;
    String transactionType;
    String cardSequenceNumber;
    String terminalTransactionDate;
    String terminalCapabilityProfile;
    String terminalCountryCode;
    String unpredictableNumber;
    String applicationTransactionCounter;
    String applicationInterchangeProfile;
    String applicationCryptogram;
    String terminalVerificationResults;
    String amountAuthorized;
    String formFactorIndicator;
    String dedicatedFileNameApplicationID_AID;
    String tapToPhoneIndicator;
    String reserved;

    EMVData2 emvData2;


}
