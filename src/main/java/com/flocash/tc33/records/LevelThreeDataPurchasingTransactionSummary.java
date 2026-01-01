package com.flocash.tc33.records;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LevelThreeDataPurchasingTransactionSummary {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String discountAmount;
    String discountAmountSignage;
    String freightShippingAmount;
    String freightShippingAmountSignage;
    String dutyAmount;
    String dutyAmountSignage;
    String vatTaxAmount;
    String vatTaxAmountSignage;
    String uniqueVatInvoiceRefNumber;
    String orderDate;
    String vatTaxRateFreightShipping;
    String summaryCommodityCode;
    String invoiceLevelDiscountTreatment;
    String taxTreatment;
    String mastercardCardAcceptorReferenceNumber;
    String mastercardCardAcceptorVatNumber;
    String mastercardCustomerVatNumber;
    String reserved;
}
