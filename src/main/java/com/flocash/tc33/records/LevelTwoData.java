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
public class LevelTwoData {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String destinationIdentifier;
    String sourceIdentifier;
    String tc33ApplicationCode;
    String messageIdentifier;
    String localTax;
    String localTaxIncluded;
    String nationalTax;
    String nationalTaxIncluded;
    String customerCodeCustomerReferenceIdentifierCRI;
    String merchantVatRegistrationSingleBusinessReferenceNumber;
    String reserved;

    LevelTwoDataAmericanExpress levelTwoDataAmericanExpress = new LevelTwoDataAmericanExpress();
    LevelThreeDataPurchasingTransactionSummary levelThreeDataPurchasingTransactionSummary = new LevelThreeDataPurchasingTransactionSummary();
    LevelThreeDataPurchasingTransactionSummary2 levelThreeDataPurchasingTransactionSummary2 = new LevelThreeDataPurchasingTransactionSummary2();
}
