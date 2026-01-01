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
public class EUSpecificProcessing {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String delegatedAuthenticationIndicator;
    String lowValueExemptionIndicator;
    String transactionRiskAnalysisExemptionIndicator;
    String trustedMerchantExemptionIndicator;
    String secureCorporatePaymentIndicator;
    String spainLocalMCC;
    String spainLocalMerchantID;
    String sessionID;
    String reasonsForNotHonoringSCAExemptions;
    String reserved;
}
