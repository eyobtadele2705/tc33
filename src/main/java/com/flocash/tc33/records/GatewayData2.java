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
public class GatewayData2 {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String ucafStatusUcafCollectionIndicator;
    String dinersDiscoverNetworkInformation;
    String dinersDiscoverTransactionQualifier;
    String gatewayTransactionIdentifier;
    String responseDataMerchantAdviceCode;
    String mcAmexDiscoverDataCodes;
    String mcAVVVerificationProgramProtocol;
    String mastercardAVVVerificationDirectoryServerTransactionID;
    String transitTransactionTypeIndicator;
    String transportationModeIndicator;
    String cavvValuePosition4;
    String merchantPaymentGatewayID;
}
