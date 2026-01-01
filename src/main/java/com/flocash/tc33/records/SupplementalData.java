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
public class SupplementalData {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String surchargeAmount;
    String surchargeCreditDebitIndicator;
    String dynamicCurrencyConversionCCCIndicator;
    String cashbackAmount;
    String acquirerMerchantID;
    String tokenAssuranceMethod;
    String tokenRequestorID;
    String panAccountRange;
    String regulatedNonRegulatedStatus;
    String agentUniqueID;
    String cavvVersionAndAuthenticationAction;
    String paymentAccountReferenceNumberPAR;
    String businessApplicationIdentifierBAI;
    String merchantTaxID;
    String specialConditionIndicator;
    String mastercardUCAFData;
    String multipleClearingSequenceNumber;
    String multipleClearingSequenceCount;
    String additionalTokenResponseInformation;
    String merchantToAcquirerRouting;
    String merchantVolumeIndicator;
    String foreignRetailerIndicator;
}
