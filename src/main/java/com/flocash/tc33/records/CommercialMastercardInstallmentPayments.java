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
public class CommercialMastercardInstallmentPayments {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String financingType;
    String buyerTypeID;
    String buyerID;
    String buyerPhoneNumber;
    String purchaseIdentification;
    String installmentCycles;
    String interestRate;
    String gracePeriod;
    String gracePeriodCycle;
    String gracePeriodInterestRate;
    String referenceField1;
    String referenceField2;
    String reserved;
}
