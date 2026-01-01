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
public class EMVData2 {

    private String additionalEmvTag;
    private String additionalEmvValue;

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String issuerApplicationData;
    String issuerScript1Results;
    String cryptogramInformationDataCID;
    String cardholderVerificationMethodCVMResults;
    String terminalApplicationVersionNumber;
    String transactionSequenceCounter;
    String applicationUsageControl;
    String applicationIdentifierAIDTerminal;
    String issuerAuthenticationData;
    String reserved;

}
