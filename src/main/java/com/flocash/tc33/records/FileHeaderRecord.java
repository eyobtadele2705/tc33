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
public class FileHeaderRecord {

    private String transactionCode;
    private String centerInformationBlock;
    private String processingDate;
    private String reserved;
    private String testOption;
    private String reserved2;
    private String securityCode;
    private String reserved3;
    private String outgoingFileId;
    private String reserved4;
}
