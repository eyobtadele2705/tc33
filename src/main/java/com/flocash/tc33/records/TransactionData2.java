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
public class TransactionData2 {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String destinationIdentifier;
    String sourceIdentifier;
    String tc33ApplicationCode;
    String messageIdentifier;
    String persistentFXExchangeProvider;
    String persistentFXExchangeRate;
    String transactionLocalDateAndTime;
    String reserved;

    MerchantData2 merchantData2;
    MerchantData3 merchantData3;
    GatewayDataContinuation gatewayDataContinuation;
    GatewayDataContinuation2 gatewayDataContinuation2;
}
