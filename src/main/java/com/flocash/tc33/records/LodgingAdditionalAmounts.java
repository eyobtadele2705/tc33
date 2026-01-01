package com.flocash.tc33.records;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class LodgingAdditionalAmounts {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String totalTax;
    String foodAndBeverageCharges;
    String totalRoomTax;
    String adjustmentAmount;
    String phoneCharges;
    String restaurantCharges;
    String laundryCharges;
    String movieCharges;
    String loungeBarCharges;
    String earlyDepartureCharges;
    String prepaidExpenses;
    String otherCharges;
    String giftShopCharges;
    String reserved;
}
