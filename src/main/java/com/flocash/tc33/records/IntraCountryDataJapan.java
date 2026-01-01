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
public class IntraCountryDataJapan {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String countryCode;
    String numberOfBonusPayments;
    String bonusMonthSign;
    String bonusAmount;
    String numberOfInstallmentPayments;
    String paymentMode;
    String netSalesAmount;
    String taxAndMailingCharge;
    String salesDraftReferenceNumber;
    String acquiringBankMerchantNumber;
    String merchantNameKatakana;
    String merchantNameKanji;
    String terminalIdentificationNumber;
    String salesSlipNumber;
    String reserved;
}
