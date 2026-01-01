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
public class ColombiaMastercardDomesticProcessing {
    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String mastercardPurchaseTaxIVA;
    String mastercardPurchaseTaxAmountBase;
    String mastercardPurchaseRetailerData;
    String mastercardPurchaseTerminalAcquirerData;
    String mastercardPurchaseBillPaymentTopUpData;
    String mastercardPurchaseLocalPOSData;
    String mastercardPurchaseLocalResponseCodes;
    String mastercardPurchaseOriginalTransactionData;
    String mastercardPurchaseIACTaxAmount;
    String reserved;
}
