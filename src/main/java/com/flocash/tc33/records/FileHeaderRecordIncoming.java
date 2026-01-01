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
public class FileHeaderRecordIncoming {

    private String transactionCode;
    private String centerInformationBlock;
    private String processingDate;
    private String reserved;
    private String settlementDate;
    private String reserved2;
    private String releaseNumber;
    private String testOption;
    private String reserved3;
    private String securityCode;
    private String reserved4;
    private String incomingFileId;
    private String reserved5;
}