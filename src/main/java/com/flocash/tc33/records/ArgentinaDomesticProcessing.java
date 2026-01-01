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
public class ArgentinaDomesticProcessing {
    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String countryCode;
    String purchaseReceiptNumber;
    String localDate;
    String installmentType;
    String numberOfInstallments;
    String installmentAmount;
    String consumerDeferredSale;
    String interestRateAmount;
    String reserved;
}
