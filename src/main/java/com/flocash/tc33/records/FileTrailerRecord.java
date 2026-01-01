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
public class FileTrailerRecord {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String destinationIdentifier;
    String sourceIdentifier;
    String applicationCode;
    String captureFileNumber;
    String captureCreationDate;
    String totalTransactionCount;
    String totalTransactionAmount;
    String reserved;
}