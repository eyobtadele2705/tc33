package com.flocash.tc33.records;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(NON_NULL)
public class BatchTrailerRecord {

    private String transactionCode;
    private String transactionCodeQualifier;
    private String transactionComponentSequence;
    private String centerInformationBlock;
    private String processingDate;
    private String destinationAmount;
    private String numberOfMonetaryTransactions;
    private String batchNumber;
    private String numberOfTCRs;
    private String reserved1;
    private String centerBatchId;
    private String numberOfTransactions;
    private String reserved2;
    private String sourceAmount;
    private String reserved3;
    private String reserved4;
    private String reserved5;
    private String reserved6;

}
