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
public class DomesticProcessingChileNationalData {

    String transactionCode;
    String transactionCodeQualifier;
    String transactionComponentSequenceNumber;
    String countryCode;
    String totalPurchaseAmount;
    String numberOfInstallments;
    String installmentType;
    String installmentAmount;
    String transactionInterestRate;
    String deferredPeriod;
    String simulationFlag;
    String issuerGracePeriodFlag;
    String merchantGracePeriod;
    String deferredPeriodSimulationFlag;
    String reservedForAnnualEquivalentChargeRateCAE;
    String domesticECommerceTool;
    String domesticECommerceToolData;
    String reserved;
}
