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
public class PushPayment {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String destinationIdentifier;
    String sourceIdentifier;
    String tc33ApplicationCode;
    String messageIdentifier;
    String aftForeignExchangeFee;
    String octAccountType;
    String octAmountType;
    String octAmountSign;
    String purposeOfPaymentCode;
    String octAcceptorLegalBusinessName;
    String octPaymentFacilitatorName;
    String reserved;

    PushPaymentOriginalCreditTransaction pushPaymentOriginalCreditTransaction;
    OriginalCreditTransactionAndAccountFundingTransaction originalCreditTransactionAndAccountFundingTransaction;
    SenderName senderName;
    RecipientName recipientName;
    RecipientAdditionalData recipientAdditionalData;
    AccountFundingTransactionDetails accountFundingTransactionDetails;

}
