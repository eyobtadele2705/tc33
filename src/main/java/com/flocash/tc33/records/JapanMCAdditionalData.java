package com.flocash.tc33.records;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JapanMCAdditionalData {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String japanDomesticPOSData;
    String acquirerCompanyCode;
    String issuerCompanyCode;
    String authorizationTransmissionMode;
    String entryIndicator;
    String approvalNumberForPostApprovalAuthorizations;
    String taxAmount;
    String localTransactionDate;
    String reserved;
}
