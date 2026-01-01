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
public class MerchantData {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String merchantName;
    String merchantStreetAddress;
    String merchantCity;
    String merchantStateProvinceCode;
    String merchantPostalCode;
    String merchantCountryCode;
    String merchantTelephoneNumber;
    String merchantUrlEmail;
    String merchantCategoryCode;
    String merchantVerificationValue;
    String regionCode;
    String reserved;
}
