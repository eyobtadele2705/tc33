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
public class MerchantData2 {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String visaMerchantID;
    String systemTraceAuditName;
    String exchangeRateTableID;
    String persistentFXEligibleIndicator;
    String persistentFXAppliedIndicator;
    String localTax;
    String localTaxIncluded;
    String nationalTax;
    String nationalTaxIncluded;
    String totalTaxesAmount;
    String indianIssuedCardRecurrentPaymentType;
    String indianIssuedCardRecurrentPaymentAmountIndicator;
    String indianIssuedCardRecurrentPaymentNumber;
    String indianIssuedCardRecurrentPaymentFrequency;
    String indianIssuedCardRecurrentRegistrationReferenceNumber;
    String indianIssuedCardMaximumRecurrentPaymentAmount;
    String indianIssuedCardRecurrentValidationIndicator;
    String agreementIDChoiceProgram;
    String electricVehicleConnectorType;
    String electricVehicleChargingReasonCode;
    String reserved;
}
