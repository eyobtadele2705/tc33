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
public class InstallmentPayment {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String installmentPaymentTotalAmount;
    String installmentPaymentCurrencyCode;
    String numberOfInstallments;
    String amountOfEachInstallment;
    String installmentPaymentNumber;
    String frequencyOfInstallments;
    String installmentPlanType;
    String mastercardInterestRate;
    String mastercardInstallmentFee;
    String mastercardAnnualPercentageRate;
    String mastercardSubsequentInstallmentAmount;
    String mastercardMinimumNumberOfInstallments;
    String mastercardMaximumNumberOfInstallments;
    String mastercardCroatiaDomesticCardAcceptorTaxID;
    String mastercardGracePeriodDetails;
    String mastercardFirstInstallmentDueDate;
    String mastercardFinancingCurrency;
    String vatForInstallmentPaymentInterest;
    String reserved;
}
