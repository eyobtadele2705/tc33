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
public class TransactionData {

    private String transactionCode;
    private String transactionCodeQualifier;
    private String transactionComponentSequenceNumber;
    private String destinationIdentifier;
    private String sourceIdentifier;
    private String applicationCode;
    private String messageIdentifier;
    private String transactionIdentifier;
    private String retrievalReferenceNumber;
    private String accountNumber;
    private String accountNumberExtension;
    private String expirationDate;
    private String purchaseDate;
    private String authorizationDate;
    private String decimalPositionsIndicator;
    private String authorizedAmount;
    private String authorizationCurrencyCode;
    private String totalAuthorizedAmount;
    private String sourceAmount;
    private String sourceCurrencyCode;
    private String tipAmount;
    private String actionCode;
    private String serviceIdentifier;
    private String acquiringIdentifier;
    private String messageReasonCode;
    private String additionalAuthorizationIndicator;
    private String domesticSwitchId;

    public AdditionalData additionalData;
    public SupplementalData supplementalData;

    public BillingAndShipping billingAndShipping;
    public BillingAndShipping2 billingAndShipping2;

    public MerchantData merchantData;
    public GatewayData gatewayData;
    public GatewayData2 gatewayData2;
    public InstallmentPayment installmentPayment;

    public ArgentinaDomesticProcessing argentinaDomesticProcessing;
    public BrazilNationalData brazilNationalData;
    public DomesticProcessingChileNationalData domesticProcessingChileNationalData;
    public ProcessingUruguayNationalData processingUruguayDomesticProcessing;
    public IntraCountryDataColombia intraCountryDataColombia;
    public IntraCountryDataIndia intraCountryDataIndia;
    public IntraCountryDataJapan intraCountryDataJapan;
    public IntraCountryDataMexico intraCountryDataMexico;
    public IntraCountryDataSouthAfrica intraCountryDataSouthAfrica;
    public BrazilCountryDataPARC brazilCountryDataPARC;
    public BrazilCountryDataBNDES brazilCountryDataBNDES;
    public BrazilCountryDataAmericanExpress brazilCountryDataAmericanExpress;
    public BrazilCountryDataMastercardBNDES1 brazilCountryDataMastercardBNDES1;
    public ColombiaMastercardDomesticProcessing colombiaMastercardDomesticProcessing;

    public CurrencyConversion currencyConversion;

    public GatewayData3 gatewayData3;
}
