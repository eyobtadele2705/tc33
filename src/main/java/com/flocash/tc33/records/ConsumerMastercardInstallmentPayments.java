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
public class ConsumerMastercardInstallmentPayments {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String insuranceAmount;
    String percentInsuranceOfTotalAmount;
    String percentAmountToMerchantOfTotalAmount;
    String monthlyInterestRate;
    String feeAmount;
    String totalAmountToMerchant;
    String taxAmount;
    String percentFeeOfTotalAmount;
    String percentTaxesOfTotalAmount;
    String otherAmount;
    String percentOtherOfTotalAmount;
    String percentTotalEffectiveCost;
    String totalEffectiveCost;
    String reserved;
}
