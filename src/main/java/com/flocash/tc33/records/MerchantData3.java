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
public class MerchantData3 {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String mastercardAccountLevelManagementServiceData;
    String mastercardAcceptorStreetAddress;
    String mastercardAcceptorCountrySubdivisionCode;
    String mastercardAcceptorCustomerServicePhoneNumber;
    String mastercardServiceLocationCityName;
    String mastercardServiceLocationStateProvinceCode;
    String mastercardServiceLocationCountryCode;
    String reserved;
}
