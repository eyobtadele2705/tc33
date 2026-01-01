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
public class PushPaymentOriginalCreditTransaction {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String businessFormatCode;
    String moneyTransferRecipientName;
    String sourceOfFunds;
    String claimsCode;
    String taxDocumentType;
    String customerReferenceNumber;
    String identificationTypeCode;
    String identificationSubtype;
    String identificationValue;
    String identificationIssuingCountry;
    String contactInformationAccountReferenceNumber;
    String contactInformationEntityType;
    String reserved;
}
