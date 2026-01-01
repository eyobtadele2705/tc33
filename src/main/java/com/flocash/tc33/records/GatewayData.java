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
public class GatewayData {
    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String timeStamp;
    String merchantSicCode;
    String mastercardPOSEntryMode;
    String mastercardPOSPINCaptureCode;
    String mastercardAmericanExpressPOSData;
    String mastercardDateAndTime;
    String mastercardICA;
    String mastercardAssignedIDMAID;
    String mastercardPaymentInitiationChannel;
    String mastercardElectronicCommerceIndicators;
    String mastercardServiceCode;
    String mastercardAccountNumberIndicator;
    String mastercardProductCode;
    String mastercardWalletIndicator;
    String mastercardElectronicCommerceIndicatorsCardholderAuthentication;
    String mastercardTerminalComplianceIndicator;
    String mastercardMobileRemotePaymentProgramIndicator;
    String marketplaceIdentifierPaymentFacilitatorID;
    String independentSalesOrganizationID;
    String subMerchantID;
    String mastercardMemberDefinedData;
    String mastercardMerchantOnBehalfService;
    String mastercardMerchantOnBehalfResults;
    String mastercardTransactionIntegrityClassification;
    String mastercardReasonForUCAFCollectionIndicatorDowngrade;
    String mastercardEIDRequestValue;
    String mastercardMCmPOSTransactionScenario;
    String mastercardMealVoucherDirectSettlementIndicator;
    String mastercardLowRiskMerchantIndicator;
    String mastercardMerchantCountryOfOriginIdentifier;
    String mastercardCITAndMITIndicators;
    String transactionTypeIdentifier;
    String mastercardAccountNumberIndicator2; // Renamed to avoid duplicate name
    String reserved;

    private String gatewayId;
    private String gatewayPassword;
    private String gatewayVersion;
}
