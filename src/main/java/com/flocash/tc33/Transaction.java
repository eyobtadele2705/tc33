package com.flocash.tc33;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flocash.tc33.records.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(NON_NULL)
public class Transaction {

    @JsonProperty("CP01-TransactionData")
    TransactionData transactionData = new TransactionData();
    @JsonProperty("CP02-EMVData")
    EMVData emvData;
    @JsonProperty("CP03-LodgingSummary")
    LodgingSummary lodgingSummary;
    @JsonProperty("CP04-LevelIIData")
    LevelTwoData levelTwoData;
    @JsonProperty("CP05-PassengerItineraryData")
    PassengerItineraryData passengerItineraryData;
    @JsonProperty("CP06-EnhancedDataPurchasingTransactionLineItemDetail")
    EnhancedDataPurchasingTransactionLineItemDetail enhancedDataPurchasingTransactionLineItemDetail;
    @JsonProperty("CP07-CountryData")
    CountryData countryData;
    @JsonProperty("CP08-DiscretionaryDataDefault")
    DiscretionaryDataDefault discretionaryDataDefault;
    @JsonProperty("CP09-PushPayment")
    PushPayment pushPayment;
    @JsonProperty("CP10-CarRentalDefault")
    CarRentalDefault carRentalDefault;
    @JsonProperty("CP12-TransactionData")
    TransactionData2 transactionData2;
}
