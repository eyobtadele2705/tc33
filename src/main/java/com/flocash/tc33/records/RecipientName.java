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
public class RecipientName {

    private String transactionCode;
    private String transactionCodeQualifier;
    private String transactionComponentSequenceNumber;
    private String accountOwnerNameGiven;
    private String accountOwnerMiddleName;
    private String accountOwnerLastName;
    private String reserved;
}
