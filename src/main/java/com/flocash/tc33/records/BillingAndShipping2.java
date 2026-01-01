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
public class BillingAndShipping2 {
    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String shipToCountryCode;
    String addressLine1;
    String addressLine2;
    String city;
    String state;
    String countryCode;
    String reserved;

    private String additionalInfo;
}
