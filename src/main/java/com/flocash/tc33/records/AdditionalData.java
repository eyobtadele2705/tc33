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
public class AdditionalData {

    private String transactionCode;
    private String transactionCodeQualifier;
    private String transactionComponentSequenceNumber;
    private String captureDate;
    private String authorizationCode;
    private String posEntryMode;
    private String cardAcceptorId;
    private String terminalId;
    private String mailPhoneElectronicCommerceAndPaymentIndicator;

    private String unattendedAcceptanceTerminalIndicator;
    private String avsResponseCode;
    private String authorizationSourceCode;
    private String purchaseIdentifierFormat;
    private String purchaseIdentifier;
    private String cardId;
    private String pointOfServiceConditionCode;
    private String processingCode;
    private String networkId;
    private String authorizationResponseCode;
    private String validationCode;
    private String marketSpecificAuthorizationDataIndicator;
    private String productId;
    private String programId;
    private String cvv2ResultCode;
    private String authorizationCharacteristicsIndicator;
    private String posTerminalCapability;
    private String cardholderIdMethod;
    private String requestId;
    private String electronicCommerceGoodsIndicator;
    private String feeProgramIndicator;
    private String serviceDevelopmentField;
    private String accountSelection;
    private String posEnvironment;
    private String timeOfPurchase;
    private String batchRequestId;
    private String spendQualifiedIndicator;
    private String cavvResultsCode;
}
