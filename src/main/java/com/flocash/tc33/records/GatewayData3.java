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
public class GatewayData3 {
    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String americanExpressSellerTelephoneNumber;
    String americanExpressSellerEmailAddress;
    String americanExpressSellerID;
    String americanExpressLast4PANReturnIndicator;
    String americanExpressPANExtended;
    String americanExpressSellerName;
    String merchantConsumerTransactionIndicator;
    String americanExpressMobileDeviceType;
    String amexExpressPANExtendedResponseCode;
    String americanExpressFunctionCode;
    String reserved;
}
