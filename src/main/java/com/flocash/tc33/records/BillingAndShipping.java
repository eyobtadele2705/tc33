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
public class BillingAndShipping {
    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String billToLastName;
    String billToFirstName;
    String billToPostalCode;
    String shipToPostalCode;
    String shipToStateProvinceCode;
    String shipFromPostalCode;
}
