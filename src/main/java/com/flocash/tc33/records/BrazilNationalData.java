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
public class BrazilNationalData {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String countryCode;
    String totalAmount;
    String currencyCode;
    String numberOfInstallments;
    String amountOfEachInstallment;
    String installmentPaymentNumber;
    String frequencyOfInstallments;
    String dateOfFirstInstallment;
    String totalAmountFunded;
    String percentOfAmountRequested;
    String totalExpenses;
    String percentOfTotalExpense;
    String totalFees;
    String percentOfTotalFees;
    String totalTaxes;
    String percentOfTotalTaxes;
    String totalInsurance;
    String percentOfTotalInsurance;
    String totalOtherCosts;
    String percentOfTotalOtherCosts;
    String monthlyInterestRate;
    String annualInterestRate;
    String annualTotalCostOfFinancing;
    String installmentPaymentType;
    String reserved;

}
