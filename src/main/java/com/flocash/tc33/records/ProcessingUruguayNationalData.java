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
public class ProcessingUruguayNationalData {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String monthsDeferred;
    String reserved1;
    String invoiceAmount;
    String taxBenefitTotalAmount;
    String amountBeforeDiscountTransactionOriginalAmount;
    String baseAmountForTaxBenefitsCalculation;
    String basisPointsAppliedByTheLaw;
    String merchantsInvoiceSerialNumber;
    String fiscalBenefitsRetentionAgent;
    String orderNumber;
    String promotionCode;
    String cardholderIDForRecurringPayments;
    String annualTotalCostOfFinancing;
    String installmentPaymentInterest;
    String lawIdentification;
    String billingPeriodMCRecurringTransaction;
    String referenceNumberMCRecurringTransaction;
    String vatRate;
    String floorLimitAppliedByTaxBenefitLaw;
    String reserved2;
}
