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
public class FileHeader {

    private String transactionCode;
    private String transactionCodeQualifier;
    private String transactionComponentSequenceNumber;
    private String destinationIdentifier;
    private String sourceIdentifier;
    private String applicationCode;
    private String captureFileNumber;
    private String captureCreationDate;
    private String reserved;
}
