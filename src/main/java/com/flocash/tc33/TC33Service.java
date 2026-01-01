
package com.flocash.tc33;

import com.flocash.tc33.records.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Slf4j
@Service
public class TC33Service {



    // existing file-level records
    public FileHeaderRecord fileHeaderRecord = new FileHeaderRecord();
    public FileHeaderRecordIncoming fileHeaderRecordIncoming = new FileHeaderRecordIncoming();
    public BatchTrailerRecord batchTrailerRecord = new BatchTrailerRecord();
    public FileTrailerRecord fileTrailerRecord = new FileTrailerRecord();

    public BatchRecord batchRecord = new BatchRecord();
    public List<BatchRecord> batchRecords = new ArrayList<>();

    public Wrapper wrapper = new Wrapper();

    // file and trailer/header records
    public FileHeader fileHeader = new FileHeader();
    public FileTrailer fileTrailer = new FileTrailer();

    public Map<Integer, Transaction> transactionMap = new HashMap<>();
    public Transaction transaction = new Transaction();
    public List<Transaction> transactions = new ArrayList<>();

    // transaction and related records
    public TransactionData transactionData = new TransactionData();
    public TransactionData2 transactionData2 = new TransactionData2();
    public AdditionalData additionalData = new AdditionalData();
    public SupplementalData supplementalData = new SupplementalData();

    // billing / shipping
    public BillingAndShipping billingAndShipping = new BillingAndShipping();
    public BillingAndShipping2 billingAndShipping2 = new BillingAndShipping2();

    // merchant / gateway
    public MerchantData merchantData = new MerchantData();
    public MerchantData2 merchantData2 = new MerchantData2();
    public MerchantData3 merchantData3 = new MerchantData3();
    public GatewayData gatewayData = new GatewayData();
    public GatewayData2 gatewayData2 = new GatewayData2();
    public GatewayData3 gatewayData3 = new GatewayData3();
    public GatewayDataContinuation gatewayDataContinuation = new GatewayDataContinuation();
    public GatewayDataContinuation2 gatewayDataContinuation2 = new GatewayDataContinuation2();

    // installment / payment / push
    public InstallmentPayment installmentPayment = new InstallmentPayment();
    public CommercialMastercardInstallmentPayments commercialMastercardInstallmentPayments = new CommercialMastercardInstallmentPayments();
    public ConsumerMastercardInstallmentPayments consumerMastercardInstallmentPayments = new ConsumerMastercardInstallmentPayments();
    public PushPayment pushPayment = new PushPayment();
    public PushPaymentOriginalCreditTransaction pushPaymentOriginalCreditTransaction = new PushPaymentOriginalCreditTransaction();
    public OriginalCreditTransactionAndAccountFundingTransaction originalCreditTransactionAndAccountFundingTransaction = new OriginalCreditTransactionAndAccountFundingTransaction();
    public AccountFundingTransactionDetails accountFundingTransactionDetails = new AccountFundingTransactionDetails();

    // merchant/proc country/national data
    public ArgentinaDomesticProcessing argentinaDomesticProcessing = new ArgentinaDomesticProcessing();
    public BrazilNationalData brazilNationalData = new BrazilNationalData();
    public DomesticProcessingChileNationalData domesticProcessingChileNationalData = new DomesticProcessingChileNationalData();
    public ProcessingUruguayNationalData processingUruguayDomesticProcessing = new ProcessingUruguayNationalData();
    public IntraCountryDataColombia intraCountryDataColombia = new IntraCountryDataColombia();
    public IntraCountryDataIndia intraCountryDataIndia = new IntraCountryDataIndia();
    public IntraCountryDataJapan intraCountryDataJapan = new IntraCountryDataJapan();
    public IntraCountryDataMexico intraCountryDataMexico = new IntraCountryDataMexico();
    public IntraCountryDataSouthAfrica intraCountryDataSouthAfrica = new IntraCountryDataSouthAfrica();
    public BrazilCountryDataPARC brazilCountryDataPARC = new BrazilCountryDataPARC();
    public BrazilCountryDataBNDES brazilCountryDataBNDES = new BrazilCountryDataBNDES();
    public BrazilCountryDataAmericanExpress brazilCountryDataAmericanExpress = new BrazilCountryDataAmericanExpress();
    public BrazilCountryDataMastercardBNDES1 brazilCountryDataMastercardBNDES1 = new BrazilCountryDataMastercardBNDES1();
    public ColombiaMastercardDomesticProcessing colombiaMastercardDomesticProcessing = new ColombiaMastercardDomesticProcessing();
    public BrazilCountryDataMastercardBNDES1 brazilCountryDataMastercardBNDES1_duplicate_safe = new BrazilCountryDataMastercardBNDES1(); // if needed distinct

    // currency / conversion / level data
    public CurrencyConversion currencyConversion = new CurrencyConversion();
    public LevelTwoData levelTwoData = new LevelTwoData();
    public LevelTwoDataAmericanExpress levelTwoDataAmericanExpress = new LevelTwoDataAmericanExpress();
    public LevelThreeDataPurchasingTransactionSummary levelThreeDataPurchasingTransactionSummary = new LevelThreeDataPurchasingTransactionSummary();
    public LevelThreeDataPurchasingTransactionSummary2 levelThreeDataPurchasingTransactionSummary2 = new LevelThreeDataPurchasingTransactionSummary2();

    // enhanced / purchasing item details
    public EnhancedDataPurchasingTransactionLineItemDetail enhancedDataPurchasingTransactionLineItemDetail = new EnhancedDataPurchasingTransactionLineItemDetail();
    public PurchasingTransactionLineItemDetail purchasingTransactionLineItemDetail = new PurchasingTransactionLineItemDetail();

    // country / misc records
    public CountryData countryData = new CountryData();
    public DebtRepaymentInformation debtRepaymentInformation = new DebtRepaymentInformation();
    public JapanMCAdditionalData japanMCAdditionalData = new JapanMCAdditionalData();
    public EUSpecificProcessing euSpecificProcessing = new EUSpecificProcessing();
    public PolandMCSpecificCommercialCards polandMCSpecificCommercialCards = new PolandMCSpecificCommercialCards();
    public DiscretionaryDataDefault discretionaryDataDefault = new DiscretionaryDataDefault();
    public FreeFormText freeFormText = new FreeFormText();

    // lodging
    public LodgingSummary lodgingSummary = new LodgingSummary();
    public LodgingSummary2 lodgingSummary2 = new LodgingSummary2();
    public LodgingSummary3 lodgingSummary3 = new LodgingSummary3();
    public LodgingAdditionalAmounts lodgingAdditionalAmounts = new LodgingAdditionalAmounts();
    public LodgingAdditionalAmounts2 lodgingAdditionalAmounts2 = new LodgingAdditionalAmounts2();

    // passenger / itinerary / transport
    public PassengerItineraryData passengerItineraryData = new PassengerItineraryData();
    public PassengerItineraryData2 passengerItineraryData2 = new PassengerItineraryData2();
    public PassengerItineraryData3 passengerItineraryData3 = new PassengerItineraryData3();
    public PassengerItineraryData4 passengerItineraryData4 = new PassengerItineraryData4();
    public PassengerItineraryData5 passengerItineraryData5 = new PassengerItineraryData5();
    public PassengerItineraryData6 passengerItineraryData6 = new PassengerItineraryData6();
    public PassengerTransport passengerTransport = new PassengerTransport();
    public PassengerItineraryData7 passengerItineraryData7 = new PassengerItineraryData7();

    // car rental
    public CarRentalDefault carRentalDefault = new CarRentalDefault();
    public CarRentalDefault2 carRentalDefault2 = new CarRentalDefault2();
    public CarRentalDefault3 carRentalDefault3 = new CarRentalDefault3();
    public CarRentalDefault4 carRentalDefault4 = new CarRentalDefault4();
    public CarRentalDefault5 carRentalDefault5 = new CarRentalDefault5();

    // enhanced/gateway/emv
    public EMVData emvData = new EMVData();
    public EMVData2 emvData2 = new EMVData2();
    public GatewayDataContinuation gatewayDataContinuationDuplicateSafe = new GatewayDataContinuation(); // if distinct instances needed

    // sender / recipient
    public SenderName senderName = new SenderName();
    public RecipientName recipientName = new RecipientName();
    public RecipientAdditionalData recipientAdditionalData = new RecipientAdditionalData();

    // miscellaneous
    public CommercialMastercardInstallmentPayments commercialInstallment = new CommercialMastercardInstallmentPayments();
    public ConsumerMastercardInstallmentPayments consumerInstallment = new ConsumerMastercardInstallmentPayments();

    // constructors, methods and parsers remain unchanged below

    private final List<String> ESCAPE_CHARACTERS = Arrays.asList("HEDR", "TRLR", "CP01", "CP02", "CP03", "CP04", "CP05", "CP06", "CP07", "CP08", "CP09", "CP10", "CP11", "CP12");

    public Wrapper readFile() {


        try {
            String file = "src/file/EPIN_251225.TXT";
            Path path = Paths.get(file);
            List<String> lines = Files.readAllLines(path);

            int nextLineNumber = 0;

            for (String line : lines) {
                if (line.startsWith("90")){
                    if (isEmptySpacesOfLengthFive(line.substring(19, 24))){
                        fileHeaderRecord = fileHeaderRecord(line);
                    }
                    else {
                        fileHeaderRecordIncoming = fileHeaderRecordIncoming(line);
                    }
                    nextLineNumber++;
                }
                if (line.startsWith("91")){
                    batchTrailerRecord = batchTrailerRecord(line);
                    batchRecord.setBatchTrailerRecord(batchTrailerRecord);
                    batchRecords.add(batchRecord);
                    nextLineNumber++;

                }
                if (line.startsWith("92")){
                    fileTrailerRecord = fileTrailerRecord(line);

                    if (fileHeaderRecord != null && !Objects.equals(fileHeaderRecord.getTransactionCode(), null)){
                        log.info("Setting File Header Record in Wrapper");
                        wrapper.setFileHeaderRecord(fileHeaderRecord);
                    }
                    if (fileHeaderRecordIncoming != null && !Objects.equals(fileHeaderRecordIncoming.getTransactionCode(), null)){
                        wrapper.setFileHeaderRecordIncoming(fileHeaderRecordIncoming);
                    }
                    wrapper.setBatchRecords(batchRecords);
                    wrapper.setFileTrailerRecord(fileTrailerRecord);

                    batchRecord = new BatchRecord();
                    nextLineNumber++;
                }
                if(line.startsWith("33")) {
                    if (line.substring(16, 20).equalsIgnoreCase("HEDR")) {
                        fileHeader = parseFileHeader(line);
                        nextLineNumber++;
                    }

                    if (line.substring(16, 20).equalsIgnoreCase("TRLR")) {
                        transactions.add(transaction);
                        fileTrailer = parseFileTrailer(line);

                        batchRecord.setFileHeader(fileHeader);
                        batchRecord.setTransactions(transactions);
                        batchRecord.setFileTrailer(fileTrailer);
                        nextLineNumber++;
                    }

                    if (line.startsWith("CP01", 16)) {

                        if (transaction != null && !Objects.equals(transaction.getTransactionData().getTransactionCode(), null)) {
                            transactions.add(transaction);
                            transaction = new Transaction();
                        }

                        transactionData = parseTransactionData(line);
                        nextLineNumber++;
                        String newLine = lines.get(nextLineNumber);
                        log.info("Processing CP01 record, initial new line: {}", nextLineNumber);

                        while (!ESCAPE_CHARACTERS.contains(newLine.substring(16, 20))) {
                            nextLineNumber++;

                            log.info("Inside while loop for CP01 sub-records, processing line: {}", newLine);

                            if (newLine.charAt(3) == '1'){
                                log.info("Adding Additional Data");
                                additionalData = parseAdditionalData(newLine);
                                transactionData.setAdditionalData(additionalData);
                            }
                            if (newLine.charAt(3) == '2'){
                                billingAndShipping = parseBillingAndShipping(newLine);
                                transactionData.setBillingAndShipping(billingAndShipping);
                            }
                            if (newLine.charAt(3) == '3'){
                                billingAndShipping2 = parseBillingAndShipping2(newLine);
                                transactionData.setBillingAndShipping2(billingAndShipping2);
                            }
                            if (newLine.charAt(3) == '4'){
                                merchantData = parseMerchantData(newLine);
                                transactionData.setMerchantData(merchantData);
                            }
                            if (newLine.charAt(3) == '5'){
                                installmentPayment = parseInstallmentPayment(newLine);
                                transactionData.setInstallmentPayment(installmentPayment);
                            }
                            if (newLine.charAt(3) == '6'){
                                gatewayData = parseGatewayData(newLine);
                                transactionData.setGatewayData(gatewayData);
                            }
                            if (newLine.charAt(3) == '7'){
                                gatewayData2 = parseGatewayData2(newLine);
                                transactionData.setGatewayData2(gatewayData2);
                            }
                            if (newLine.charAt(3) == '8'){
                                supplementalData = parseSupplementalData(newLine);
                                transactionData.setSupplementalData(supplementalData);
                            }
                            if (newLine.charAt(3) == '9' && newLine.startsWith("710", 4)){
                                intraCountryDataSouthAfrica = parseIntraCountryDataSouthAfrica(newLine);
                                transactionData.setIntraCountryDataSouthAfrica(intraCountryDataSouthAfrica);
                            }
                            if (newLine.charAt(3) == 'A'){
                                currencyConversion = parseCurrencyConversion(newLine);
                                transactionData.setCurrencyConversion(currencyConversion);
                            }

                            if(newLine.charAt(3) == 'B'){
                                gatewayData3 = parseGatewayData3(newLine);
                                transactionData.setGatewayData3(gatewayData3);
                            }
                            newLine = lines.get(nextLineNumber);

                        }
                        transaction.setTransactionData(transactionData);
                    }

                    if (line.startsWith("CP02", 16)) {
                        emvData = parseEMVData(line);
                        String newLine = lines.get(nextLineNumber);
                        while (!ESCAPE_CHARACTERS.contains(newLine.substring(16, 20))) {
                            nextLineNumber++;
                            if (newLine.charAt(3) == '1') {
                                emvData2 = parseEMVData2(newLine);
                                emvData.setEmvData2(emvData2);
                            }
                            newLine = lines.get(nextLineNumber);
                        }
                        transaction.setEmvData(emvData);
                    }
                    if (line.startsWith("CP03", 16)) {
                        lodgingSummary = parseLodgingSummary(line);
                        String newLine = lines.get(nextLineNumber);

                        while (!ESCAPE_CHARACTERS.contains(newLine.substring(16, 20))) {
                            nextLineNumber++;
                            if (newLine.charAt(3) == '1') {
                                lodgingSummary2 = parseLodgingSummary2(newLine);
                                lodgingSummary.setLodgingSummary2(lodgingSummary2);
                            }
                            if (newLine.charAt(3) == '2') {
                                lodgingSummary3 = parseLodgingSummary3(newLine);
                                lodgingSummary.setLodgingSummary3(lodgingSummary3);
                            }
                            if (newLine.charAt(3) == '3') {
                                lodgingAdditionalAmounts = parseLodgingAdditionalAmounts(newLine);
                                lodgingSummary.setLodgingAdditionalAmounts(lodgingAdditionalAmounts);
                            }
                            if (newLine.charAt(3) == '4') {
                                lodgingAdditionalAmounts2 = parseLodgingAdditionalAmounts2(newLine);
                                lodgingSummary.setLodgingAdditionalAmounts2(lodgingAdditionalAmounts2);
                            }
                            newLine = lines.get(nextLineNumber);
                        }
                        transaction.setLodgingSummary(lodgingSummary);
                    }
                    if (line.startsWith("CP04", 16)){
                        levelTwoData = parseLevelTwoData(line);
                        String newLine = lines.get(nextLineNumber);
                        while (!ESCAPE_CHARACTERS.contains(newLine.substring(16, 20))) {
                            nextLineNumber++;
                            if (newLine.charAt(3) == '1') {
                                levelTwoDataAmericanExpress = parseLevelTwoDataAmericanExpress(newLine);
                                levelTwoData.setLevelTwoDataAmericanExpress(levelTwoDataAmericanExpress);
                            }
                            if (newLine.charAt(3) == '2') {
                                levelThreeDataPurchasingTransactionSummary = parseLevelThreeDataPurchasingTransactionSummary(newLine);
                                levelTwoData.setLevelThreeDataPurchasingTransactionSummary(levelThreeDataPurchasingTransactionSummary);
                            }
                            if (newLine.charAt(3) == '3') {
                                levelThreeDataPurchasingTransactionSummary2 = parseLevelThreeDataPurchasingTransactionSummary2(newLine);
                                levelTwoData.setLevelThreeDataPurchasingTransactionSummary2(levelThreeDataPurchasingTransactionSummary2);
                            }
                            newLine = lines.get(nextLineNumber);
                        }
                        transaction.setLevelTwoData(levelTwoData);
                    }
                    if (line.startsWith("CP05", 16)){
                        passengerItineraryData = parsePassengerItineraryData(line);
                        String newLine = lines.get(nextLineNumber);

                        while (!ESCAPE_CHARACTERS.contains(newLine.substring(16, 20))) {
                            nextLineNumber++;
                            if (newLine.charAt(3) == '1') {
                                passengerItineraryData2 = parsePassengerItineraryData2(newLine);
                                passengerItineraryData.setPassengerItineraryData2(passengerItineraryData2);
                            }
                            if (newLine.charAt(3) == '2') {
                                passengerItineraryData3 = parsePassengerItineraryData3(newLine);
                                passengerItineraryData.setPassengerItineraryData3(passengerItineraryData3);
                            }
                            if (newLine.charAt(3) == '3') {
                                passengerItineraryData4 = parsePassengerItineraryData4(newLine);
                                passengerItineraryData.setPassengerItineraryData4(passengerItineraryData4);
                            }
                            if (newLine.charAt(3) == '4') {
                                passengerItineraryData5 = parsePassengerItineraryData5(newLine);
                                passengerItineraryData.setPassengerItineraryData5(passengerItineraryData5);
                            }
                            if (newLine.charAt(3) == '5') {
                                passengerItineraryData6 = parsePassengerItineraryData6(newLine);
                                passengerItineraryData.setPassengerItineraryData6(passengerItineraryData6);
                            }
                            if (newLine.charAt(3) == '6') {
                                passengerTransport = parsePassengerTransport(newLine);
                                passengerItineraryData.setPassengerTransport(passengerTransport);
                            }
                            if (newLine.charAt(3) == '7') {
                                passengerItineraryData7 = parsePassengerItineraryData7(newLine);
                                passengerItineraryData.setPassengerItineraryData7(passengerItineraryData7);
                            }
                            newLine = lines.get(nextLineNumber);
                        }
                        transaction.setPassengerItineraryData(passengerItineraryData);
                    }
                    if (line.startsWith("CP06", 16)){
                        enhancedDataPurchasingTransactionLineItemDetail = parseEnhancedDataPurchasingTransactionLineItemDetail(line);
                        String newLine = lines.get(nextLineNumber);
                        while (!ESCAPE_CHARACTERS.contains(newLine.substring(16, 20))) {
                            nextLineNumber++;
                            if (newLine.charAt(3) == '1') {
                                purchasingTransactionLineItemDetail = parsePurchasingTransactionLineItemDetail(newLine);
                                enhancedDataPurchasingTransactionLineItemDetail.setPurchasingTransactionLineItemDetail(purchasingTransactionLineItemDetail);
                            }
                            newLine = lines.get(nextLineNumber);
                        }
                        transaction.setEnhancedDataPurchasingTransactionLineItemDetail(enhancedDataPurchasingTransactionLineItemDetail);
                    }
                    if (line.startsWith("CP07", 16)){
                        countryData = parseCountryData(line);
                        String newLine = lines.get(nextLineNumber);
                        while (!ESCAPE_CHARACTERS.contains(newLine.substring(16, 20))) {
                            nextLineNumber++;
                            if (newLine.charAt(3) == '1') {
                                brazilCountryDataPARC = parseBrazilCountryDataPARC(newLine);
                                countryData.setBrazilCountryDataPARC(brazilCountryDataPARC);
                            }
                            if (newLine.charAt(3) == '2') {
                                brazilCountryDataBNDES = parseBrazilCountryDataBNDES(newLine);
                                countryData.setBrazilCountryDataBNDES(brazilCountryDataBNDES);
                            }
                            if (newLine.charAt(3) == '3') {
                                brazilCountryDataAmericanExpress = parseBrazilCountryDataAmericanExpress(newLine);
                                countryData.setBrazilCountryDataAmericanExpress(brazilCountryDataAmericanExpress);
                            }
                            if (newLine.charAt(3) == '4') {
                                commercialMastercardInstallmentPayments = parseCommercialMastercardInstallmentPayments(newLine);
                                countryData.setCommercialMastercardInstallmentPayments(commercialMastercardInstallmentPayments);
                            }
                            if (newLine.charAt(3) == '5') {
                                consumerMastercardInstallmentPayments = parseConsumerMastercardInstallmentPayments(newLine);
                                countryData.setConsumerMastercardInstallmentPayments(consumerMastercardInstallmentPayments);
                            }
                            if (newLine.charAt(3) == '6') {
                                brazilCountryDataMastercardBNDES1 = parseBrazilCountryDataMastercardBNDES1(newLine);
                                countryData.setBrazilCountryDataMastercardBNDES1(brazilCountryDataMastercardBNDES1);
                            }
                            if (newLine.charAt(3) == '7') {
                                debtRepaymentInformation = parseDebtRepaymentInformation(newLine);
                                countryData.setDebtRepaymentInformation(debtRepaymentInformation);
                            }
                            if (newLine.charAt(3) == '8') {
                                japanMCAdditionalData = parseJapanMCAdditionalData(newLine);
                                countryData.setJapanMCAdditionalData(japanMCAdditionalData);
                            }
                            if(newLine.charAt(3) == '9'){
                                euSpecificProcessing = parseEUSpecificProcessing(newLine);
                                countryData.setEuSpecificProcessing(euSpecificProcessing);
                            }
                            if(newLine.charAt(3) == 'A'){
                                polandMCSpecificCommercialCards = parsePolandMCSpecificCommercialCards(newLine);
                                countryData.setPolandMCSpecificCommercialCards(polandMCSpecificCommercialCards);
                            }
                            if (newLine.charAt(3) == 'B'){
                                colombiaMastercardDomesticProcessing = parseColombiaMastercardDomesticProcessing(newLine);
                                countryData.setColombiaMastercardDomesticProcessing(colombiaMastercardDomesticProcessing);
                            }
                            newLine = lines.get(nextLineNumber);
                        }
                        transaction.setCountryData(countryData);
                    }
                    if (line.startsWith("CP08", 16)){
                        discretionaryDataDefault = parseDiscretionaryDataDefault(line);
                        String newLine = lines.get(nextLineNumber);
                        while (!ESCAPE_CHARACTERS.contains(newLine.substring(16, 20))) {
                            nextLineNumber++;
                            if (newLine.charAt(3) == '1') {
                                freeFormText = parseFreeFormText(newLine);
                                discretionaryDataDefault.setFreeFormText(freeFormText);
                            }
                            newLine = lines.get(nextLineNumber);
                        }
                        transaction.setDiscretionaryDataDefault(discretionaryDataDefault);
                    }
                    if (line.startsWith("CP09", 16)){
                        pushPayment = parsePushPayment(line);
                        String newLine = lines.get(nextLineNumber);
                        while (!ESCAPE_CHARACTERS.contains(newLine.substring(16, 20))) {
                            nextLineNumber++;
                            if (newLine.charAt(3) == '1') {
                                pushPaymentOriginalCreditTransaction = parsePushPaymentOriginalCreditTransaction(newLine);
                                pushPayment.setPushPaymentOriginalCreditTransaction(pushPaymentOriginalCreditTransaction);
                            }
                            if (newLine.charAt(3) == '2') {
                                originalCreditTransactionAndAccountFundingTransaction = parseOriginalCreditTransactionAndAccountFundingTransaction(newLine);
                                pushPayment.setOriginalCreditTransactionAndAccountFundingTransaction(originalCreditTransactionAndAccountFundingTransaction);
                            }
                            if (newLine.charAt(3) == '3') {
                                senderName = parseSenderName(newLine);
                                pushPayment.setSenderName(senderName);
                            }
                            if (newLine.charAt(3) == '4') {
                                recipientName = parseRecipientName(newLine);
                                pushPayment.setRecipientName(recipientName);
                            }
                            if (newLine.charAt(3) == '5') {
                                recipientAdditionalData = parseRecipientAdditionalData(newLine);
                                pushPayment.setRecipientAdditionalData(recipientAdditionalData);
                            }
                            if (newLine.charAt(3) == '6') {
                                accountFundingTransactionDetails = parseAccountFundingTransactionDetails(newLine);
                                pushPayment.setAccountFundingTransactionDetails(accountFundingTransactionDetails);
                            }

                            newLine = lines.get(nextLineNumber);
                        }
                        transaction.setPushPayment(pushPayment);
                    }
                    if (line.startsWith("CP10", 16)){
                        carRentalDefault = parseCarRentalDefault(line);
                        String newLine = lines.get(nextLineNumber);
                        while (!ESCAPE_CHARACTERS.contains(newLine.substring(16, 20))) {
                            nextLineNumber++;
                            if (newLine.charAt(3) == '1') {
                                carRentalDefault2 = parseCarRentalDefault2(newLine);
                                carRentalDefault.setCarRentalDefault2(carRentalDefault2);
                            }
                            if (newLine.charAt(3) == '2') {
                                carRentalDefault3 = parseCarRentalDefault3(newLine);
                                carRentalDefault.setCarRentalDefault3(carRentalDefault3);
                            }
                            if (newLine.charAt(3) == '3') {
                                carRentalDefault4 = parseCarRentalDefault4(newLine);
                                carRentalDefault.setCarRentalDefault4(carRentalDefault4);
                            }
                            if (newLine.charAt(3) == '4') {
                                carRentalDefault5 = parseCarRentalDefault5(newLine);
                                carRentalDefault.setCarRentalDefault5(carRentalDefault5);
                            }
                            newLine = lines.get(nextLineNumber);
                        }
                        transaction.setCarRentalDefault(carRentalDefault);
                    }

                    if (line.startsWith("CP12", 16)){
                        nextLineNumber++;

                        log.info("Processing CP12 record at line number: {}", nextLineNumber);
                        log.info("Processing CP12 record at line: {}", line);
                        transactionData2 = parseTransactionData2(line);
                        String newLine = lines.get(nextLineNumber);
                        while (!ESCAPE_CHARACTERS.contains(newLine.substring(16, 20))) {

                            log.info("Processing CP12 sub-record line: {}", newLine);
                            nextLineNumber++;
                            if (newLine.charAt(3) == '1') {
                                merchantData2 = parseMerchantData2(newLine);
                                transactionData2.setMerchantData2(merchantData2);
                            }
                            if (newLine.charAt(3) == '2') {
                                merchantData3 = parseMerchantData3(newLine);
                                transactionData2.setMerchantData3(merchantData3);
                            }
                            if (newLine.charAt(3) == '3') {
                                gatewayDataContinuation = parseGatewayDataContinuation(newLine);
                                transactionData2.setGatewayDataContinuation(gatewayDataContinuation);
                            }
                            if (newLine.charAt(3) == '4') {
                                gatewayDataContinuation2 = parseGatewayDataContinuation2(newLine);
                                transactionData2.setGatewayDataContinuation2(gatewayDataContinuation2);
                            }
                            newLine = lines.get(nextLineNumber);
                        }
                        transaction.setTransactionData2(transactionData2);
                    }

                }

            }
        } catch (Exception e) {
            log.error("Exception caught while reading file: {}", e.getMessage());
            return null;
        }
        return wrapper;
    }

    public static boolean isEmptySpacesOfLengthFive(String str) {
        return str != null && str.equals("     ");
    }

    public FileHeader parseFileHeader(String line){
        FileHeader fileHeader = new FileHeader();
        try {
            fileHeader.setTransactionCode(line.substring(0, 2));
            fileHeader.setTransactionCodeQualifier(line.substring(2, 3));
            fileHeader.setTransactionComponentSequenceNumber(line.substring(3, 4));
            fileHeader.setDestinationIdentifier(line.substring(4, 10));
            fileHeader.setSourceIdentifier(line.substring(10, 16));
            fileHeader.setApplicationCode(line.substring(16, 20));
            fileHeader.setCaptureFileNumber(line.substring(20, 24));
            fileHeader.setCaptureCreationDate(line.substring(24, 32));
            fileHeader.setReserved(line.substring(32));
            return fileHeader;
        }
        catch (Exception e){
            log.warn("Exception caught while parsing File Header: {}", e.getMessage());
            return fileHeader;
        }
    }

    public FileTrailer parseFileTrailer(String line) {
        FileTrailer fileTrailer = new FileTrailer();

       try {
           fileTrailer.setTransactionCode(line.substring(0, 2));
           fileTrailer.setTransactionCodeQualifier(line.substring(2, 3));
           fileTrailer.setTransactionComponentSequenceNumber(line.substring(3, 4));
           fileTrailer.setDestinationIdentifier(line.substring(4, 10));
           fileTrailer.setSourceIdentifier(line.substring(10, 16));
           fileTrailer.setApplicationCode(line.substring(16, 20));
           fileTrailer.setCaptureFileNumber(line.substring(20, 24));
           fileTrailer.setCaptureCreationDate(line.substring(24, 32));
           fileTrailer.setTotalTransactionCount(line.substring(32, 41));
           fileTrailer.setTotalTransactionAmount(line.substring(41, 61));
           fileTrailer.setReserved(line.substring(61, 168));

           return fileTrailer;
       }
         catch (Exception e){
              log.warn("Exception caught while parsing File Trailer: {}", e.getMessage());
              return fileTrailer;
         }
    }

    public TransactionData parseTransactionData(String line) {
        TransactionData transactionData = new TransactionData();

        try {
            transactionData.setTransactionCode(line.substring(0, 2));
            transactionData.setTransactionCodeQualifier(line.substring(2, 3));
            transactionData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            transactionData.setDestinationIdentifier(line.substring(4, 10));
            transactionData.setSourceIdentifier(line.substring(10, 16));
            transactionData.setApplicationCode(line.substring(16, 20));
            transactionData.setMessageIdentifier(line.substring(20, 35));
            transactionData.setTransactionIdentifier(line.substring(35, 50));
            transactionData.setRetrievalReferenceNumber(line.substring(50, 62));
            transactionData.setAccountNumber(line.substring(62, 78));
            transactionData.setAccountNumberExtension(line.substring(78, 81));
            transactionData.setExpirationDate(line.substring(81, 85));
            transactionData.setPurchaseDate(line.substring(85, 89));
            transactionData.setAuthorizationDate(line.substring(89, 93));
            transactionData.setDecimalPositionsIndicator(line.substring(93, 95));
            transactionData.setAuthorizedAmount(line.substring(95, 107));
            transactionData.setAuthorizationCurrencyCode(line.substring(107, 110));
            transactionData.setTotalAuthorizedAmount(line.substring(110, 122));
            transactionData.setSourceAmount(line.substring(122, 134));
            transactionData.setSourceCurrencyCode(line.substring(134, 137));
            transactionData.setTipAmount(line.substring(137, 149));
            transactionData.setActionCode(line.substring(149, 151));
            transactionData.setServiceIdentifier(line.substring(151, 153));
            transactionData.setAcquiringIdentifier(line.substring(153, 159));
            transactionData.setMessageReasonCode(line.substring(159, 163));
            transactionData.setAdditionalAuthorizationIndicator(line.substring(163, 164));
            transactionData.setDomesticSwitchId(line.substring(164, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Transaction Data: {}", e.getMessage());
            return transactionData;
        }

        return transactionData;
    }

    public AdditionalData parseAdditionalData(String line) {
        AdditionalData additionalData = new AdditionalData();

        try {
            additionalData.setTransactionCode(line.substring(0, 2));
            additionalData.setTransactionCodeQualifier(line.substring(2, 3));
            additionalData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            additionalData.setCaptureDate(line.substring(4, 8));
            additionalData.setAuthorizationCode(line.substring(8, 14));
            additionalData.setPosEntryMode(line.substring(14, 16));
            additionalData.setCardAcceptorId(line.substring(16, 31));
            additionalData.setTerminalId(line.substring(31, 39));
            additionalData.setMailPhoneElectronicCommerceAndPaymentIndicator(line.substring(39, 40));
            additionalData.setUnattendedAcceptanceTerminalIndicator(line.substring(40, 41));
            additionalData.setAvsResponseCode(line.substring(41, 42));
            additionalData.setAuthorizationSourceCode(line.substring(42, 43));
            additionalData.setPurchaseIdentifierFormat(line.substring(43, 44));
            additionalData.setPurchaseIdentifier(line.substring(44, 69));
            additionalData.setCardId(line.substring(69, 71));
            additionalData.setPointOfServiceConditionCode(line.substring(71, 73));
            additionalData.setProcessingCode(line.substring(73, 79));
            additionalData.setNetworkId(line.substring(79, 83));
            additionalData.setAuthorizationResponseCode(line.substring(83, 85));
            additionalData.setValidationCode(line.substring(85, 89));
            additionalData.setMarketSpecificAuthorizationDataIndicator(line.substring(89, 90));
            additionalData.setProductId(line.substring(90, 92));
            additionalData.setProgramId(line.substring(92, 98));
            additionalData.setCvv2ResultCode(line.substring(98, 99));
            additionalData.setAuthorizationCharacteristicsIndicator(line.substring(99, 100));
            additionalData.setPosTerminalCapability(line.substring(100, 101));
            additionalData.setCardholderIdMethod(line.substring(101, 102));
            additionalData.setRequestId(line.substring(102, 128));
            additionalData.setElectronicCommerceGoodsIndicator(line.substring(128, 130));
            additionalData.setFeeProgramIndicator(line.substring(130, 133));
            additionalData.setServiceDevelopmentField(line.substring(133, 134));
            additionalData.setAccountSelection(line.substring(134, 135));
            additionalData.setPosEnvironment(line.substring(135, 136));
            additionalData.setTimeOfPurchase(line.substring(136, 140));
            additionalData.setBatchRequestId(line.substring(140, 166));
            additionalData.setSpendQualifiedIndicator(line.substring(166, 167));
            additionalData.setCavvResultsCode(line.substring(167));

            return additionalData;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Additional Data: {}", e.getMessage());
            return additionalData;
        }

    }

    public FileHeaderRecord fileHeaderRecord(String line){
        FileHeaderRecord fileHeaderRecord = new FileHeaderRecord();
        try{
            fileHeaderRecord.setTransactionCode(line.substring(0,2));
            fileHeaderRecord.setCenterInformationBlock(line.substring(2,8));
            fileHeaderRecord.setProcessingDate(line.substring(8, 13));
            fileHeaderRecord.setReserved(line.substring(13, 29));
            fileHeaderRecord.setTestOption(line.substring(29, 33));
            fileHeaderRecord.setReserved2(line.substring(33, 62));
            fileHeaderRecord.setSecurityCode(line.substring(62, 70));
            fileHeaderRecord.setReserved3(line.substring(70, 76));
            fileHeaderRecord.setOutgoingFileId(line.substring(76, 79));
            fileHeaderRecord.setReserved4(line.substring(79, 168));
        }
        catch (Exception e){
            return fileHeaderRecord;
        }
        return fileHeaderRecord;
    }
    public FileHeaderRecordIncoming fileHeaderRecordIncoming(String line){
        FileHeaderRecordIncoming fileHeaderRecordIncoming = new FileHeaderRecordIncoming();
        try{
            fileHeaderRecordIncoming.setTransactionCode(line.substring(0,2));
            fileHeaderRecordIncoming.setCenterInformationBlock(line.substring(2,8));
            fileHeaderRecordIncoming.setProcessingDate(line.substring(8, 13));
            fileHeaderRecordIncoming.setReserved(line.substring(13, 19));
            fileHeaderRecordIncoming.setSettlementDate(line.substring(19, 24));
            fileHeaderRecordIncoming.setReserved2(line.substring(24, 26));
            fileHeaderRecordIncoming.setReleaseNumber(line.substring(26, 29));
            fileHeaderRecordIncoming.setTestOption(line.substring(29, 33));
            fileHeaderRecordIncoming.setReserved3(line.substring(33, 62));
            fileHeaderRecordIncoming.setSecurityCode(line.substring(62, 70));
            fileHeaderRecordIncoming.setReserved4(line.substring(70, 76));
            fileHeaderRecordIncoming.setIncomingFileId(line.substring(76, 79));
            fileHeaderRecordIncoming.setReserved4(line.substring(79, 168));
        }
        catch (Exception e){
            return fileHeaderRecordIncoming;
        }
        return fileHeaderRecordIncoming;
    }


    public BatchTrailerRecord batchTrailerRecord(String line) {
        BatchTrailerRecord batchTrailerRecord = new BatchTrailerRecord();

        try {
            batchTrailerRecord.setTransactionCode(line.substring(0, 2));
            batchTrailerRecord.setTransactionCodeQualifier(line.substring(2, 3));
            batchTrailerRecord.setTransactionComponentSequence(line.substring(3, 4));
            batchTrailerRecord.setCenterInformationBlock(line.substring(4, 10));
            batchTrailerRecord.setProcessingDate(line.substring(10, 15));
            batchTrailerRecord.setDestinationAmount(line.substring(15, 30));
            batchTrailerRecord.setNumberOfMonetaryTransactions(line.substring(30, 42));
            batchTrailerRecord.setBatchNumber(line.substring(42, 48));
            batchTrailerRecord.setNumberOfTCRs(line.substring(48, 60));
            batchTrailerRecord.setReserved1(line.substring(60, 66));
            batchTrailerRecord.setCenterBatchId(line.substring(66, 74));
            batchTrailerRecord.setNumberOfTransactions(line.substring(74, 83));
            batchTrailerRecord.setReserved2(line.substring(83, 101));
            batchTrailerRecord.setSourceAmount(line.substring(101, 116));
            batchTrailerRecord.setReserved3(line.substring(116, 131));
            batchTrailerRecord.setReserved4(line.substring(131, 146));
            batchTrailerRecord.setReserved5(line.substring(146, 161));
            batchTrailerRecord.setReserved6(line.substring(161, 168));
        }
        catch (Exception e){
            return batchTrailerRecord;
        }
        return batchTrailerRecord;
    }
    public FileTrailerRecord fileTrailerRecord(String line) {
        FileTrailerRecord fileTrailerRecord = new FileTrailerRecord();

        try {
            fileTrailerRecord.setTransactionCode(line.substring(0, 2));
            fileTrailerRecord.setTransactionCodeQualifier(line.substring(2, 3));
            fileTrailerRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            fileTrailerRecord.setDestinationIdentifier(line.substring(4, 10));
            fileTrailerRecord.setSourceIdentifier(line.substring(10, 16));
            fileTrailerRecord.setApplicationCode(line.substring(16, 20));
            fileTrailerRecord.setCaptureFileNumber(line.substring(20, 24));
            fileTrailerRecord.setCaptureCreationDate(line.substring(24, 32));
            fileTrailerRecord.setTotalTransactionCount(line.substring(32, 41));
            fileTrailerRecord.setTotalTransactionAmount(line.substring(41, 61));
            fileTrailerRecord.setReserved(line.substring(61, 168));
        }
        catch (Exception e){
            return fileTrailerRecord;
        }
        return fileTrailerRecord;
    }

    public BillingAndShipping parseBillingAndShipping(String line) {
        BillingAndShipping billingAndShipping = new BillingAndShipping();

        try {
            billingAndShipping.setTransactionCode(line.substring(0, 2));
            billingAndShipping.setTransactionCodeQualifier(line.substring(2, 3));
            billingAndShipping.setTransactionComponentSequenceNumber(line.substring(3, 4));
            billingAndShipping.setBillToLastName(line.substring(4, 64));
            billingAndShipping.setBillToFirstName(line.substring(64, 124));
            billingAndShipping.setBillToPostalCode(line.substring(124, 135));
            billingAndShipping.setShipToPostalCode(line.substring(135, 155));
            billingAndShipping.setShipToStateProvinceCode(line.substring(155, 158));
            billingAndShipping.setShipFromPostalCode(line.substring(158, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Billing and Shipping: {}", e.getMessage());
            return billingAndShipping;
        }

        return billingAndShipping;
    }

    public BillingAndShipping2 parseBillingAndShipping2(String line) {
        BillingAndShipping2 billingAndShippingContinuation = new BillingAndShipping2();

        try {
            billingAndShippingContinuation.setTransactionCode(line.substring(0, 2));
            billingAndShippingContinuation.setTransactionCodeQualifier(line.substring(2, 3));
            billingAndShippingContinuation.setTransactionComponentSequenceNumber(line.substring(3, 4));
            billingAndShippingContinuation.setShipToCountryCode(line.substring(4, 7));
            billingAndShippingContinuation.setAddressLine1(line.substring(7, 47));
            billingAndShippingContinuation.setAddressLine2(line.substring(47, 87));
            billingAndShippingContinuation.setCity(line.substring(87, 137));
            billingAndShippingContinuation.setState(line.substring(137, 157));
            billingAndShippingContinuation.setCountryCode(line.substring(157, 160));
            billingAndShippingContinuation.setReserved(line.substring(160, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Billing and Shipping Continuation: {}", e.getMessage());
            return billingAndShippingContinuation;
        }

        return billingAndShippingContinuation;
    }

    public MerchantData parseMerchantData(String line) {
        MerchantData merchantData = new MerchantData();

        try {
            merchantData.setTransactionCode(line.substring(0, 2));
            merchantData.setTransactionCodeQualifier(line.substring(2, 3));
            merchantData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            merchantData.setMerchantName(line.substring(4, 29));
            merchantData.setMerchantStreetAddress(line.substring(29, 89));
            merchantData.setMerchantCity(line.substring(89, 102));
            merchantData.setMerchantStateProvinceCode(line.substring(102, 105));
            merchantData.setMerchantPostalCode(line.substring(105, 119));
            merchantData.setMerchantCountryCode(line.substring(119, 122));
            merchantData.setMerchantTelephoneNumber(line.substring(122, 136));
            merchantData.setMerchantUrlEmail(line.substring(136, 149));
            merchantData.setMerchantCategoryCode(line.substring(149, 153));
            merchantData.setMerchantVerificationValue(line.substring(153, 163));
            merchantData.setRegionCode(line.substring(163, 166));
            merchantData.setReserved(line.substring(166, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Merchant Data: {}", e.getMessage());
            return merchantData;
        }

        return merchantData;
    }

    public InstallmentPayment parseInstallmentPayment(String line) {
        InstallmentPayment installmentPayment = new InstallmentPayment();

        try {
            installmentPayment.setTransactionCode(line.substring(0, 2));
            installmentPayment.setTransactionCodeQualifier(line.substring(2, 3));
            installmentPayment.setTransactionComponentSequenceNumber(line.substring(3, 4));
            installmentPayment.setInstallmentPaymentTotalAmount(line.substring(4, 16));
            installmentPayment.setInstallmentPaymentCurrencyCode(line.substring(16, 19));
            installmentPayment.setNumberOfInstallments(line.substring(19, 22));
            installmentPayment.setAmountOfEachInstallment(line.substring(22, 34));
            installmentPayment.setInstallmentPaymentNumber(line.substring(34, 37));
            installmentPayment.setFrequencyOfInstallments(line.substring(37, 38));
            installmentPayment.setInstallmentPlanType(line.substring(38, 40));
            installmentPayment.setMastercardInterestRate(line.substring(40, 45));
            installmentPayment.setMastercardInstallmentFee(line.substring(45, 57));
            installmentPayment.setMastercardAnnualPercentageRate(line.substring(57, 62));
            installmentPayment.setMastercardSubsequentInstallmentAmount(line.substring(62, 74));
            installmentPayment.setMastercardMinimumNumberOfInstallments(line.substring(74, 76));
            installmentPayment.setMastercardMaximumNumberOfInstallments(line.substring(76, 78));
            installmentPayment.setMastercardCroatiaDomesticCardAcceptorTaxID(line.substring(78, 98));
            installmentPayment.setMastercardGracePeriodDetails(line.substring(98, 101));
            installmentPayment.setMastercardFirstInstallmentDueDate(line.substring(101, 107));
            installmentPayment.setMastercardFinancingCurrency(line.substring(107, 110));
            installmentPayment.setVatForInstallmentPaymentInterest(line.substring(110, 120));
            installmentPayment.setReserved(line.substring(120, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Installment Payment: {}", e.getMessage());
            return installmentPayment;
        }

        return installmentPayment;
    }

    public GatewayData parseGatewayData(String line) {
        GatewayData gatewayData = new GatewayData();

        try {
            gatewayData.setTransactionCode(line.substring(0, 2));
            gatewayData.setTransactionCodeQualifier(line.substring(2, 3));
            gatewayData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            gatewayData.setTimeStamp(line.substring(4, 14));
            gatewayData.setMerchantSicCode(line.substring(14, 18));
            gatewayData.setMastercardPOSEntryMode(line.substring(18, 21));
            gatewayData.setMastercardPOSPINCaptureCode(line.substring(21, 23));
            gatewayData.setMastercardAmericanExpressPOSData(line.substring(23, 49));
            gatewayData.setMastercardDateAndTime(line.substring(49, 59));
            gatewayData.setMastercardICA(line.substring(59, 65));
            gatewayData.setMastercardAssignedIDMAID(line.substring(65, 71));
            gatewayData.setMastercardPaymentInitiationChannel(line.substring(71, 73));
            gatewayData.setMastercardElectronicCommerceIndicators(line.substring(73, 80));
            gatewayData.setMastercardServiceCode(line.substring(80, 83));
            gatewayData.setMastercardAccountNumberIndicator(line.substring(83, 84));
            gatewayData.setMastercardProductCode(line.substring(84, 87));
            gatewayData.setMastercardWalletIndicator(line.substring(87, 88));
            gatewayData.setMastercardElectronicCommerceIndicatorsCardholderAuthentication(line.substring(88, 91));
            gatewayData.setMastercardTerminalComplianceIndicator(line.substring(91, 93));
            gatewayData.setMastercardMobileRemotePaymentProgramIndicator(line.substring(93, 94));
            gatewayData.setMarketplaceIdentifierPaymentFacilitatorID(line.substring(94, 105));
            gatewayData.setIndependentSalesOrganizationID(line.substring(105, 116));
            gatewayData.setSubMerchantID(line.substring(116, 131));
            gatewayData.setMastercardMemberDefinedData(line.substring(131, 132));
            gatewayData.setMastercardMerchantOnBehalfService(line.substring(132, 134));
            gatewayData.setMastercardMerchantOnBehalfResults(line.substring(134, 135));
            gatewayData.setMastercardTransactionIntegrityClassification(line.substring(135, 136));
            gatewayData.setMastercardReasonForUCAFCollectionIndicatorDowngrade(line.substring(136, 138));
            gatewayData.setMastercardEIDRequestValue(line.substring(138, 140));
            gatewayData.setMastercardMCmPOSTransactionScenario(line.substring(140, 141));
            gatewayData.setMastercardMealVoucherDirectSettlementIndicator(line.substring(141, 142));
            gatewayData.setMastercardLowRiskMerchantIndicator(line.substring(142, 145));
            gatewayData.setMastercardMerchantCountryOfOriginIdentifier(line.substring(145, 147));
            gatewayData.setMastercardCITAndMITIndicators(line.substring(147, 150));
            gatewayData.setTransactionTypeIdentifier(line.substring(150, 154));
            gatewayData.setMastercardAccountNumberIndicator(line.substring(154, 157));
            gatewayData.setReserved(line.substring(157, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Gateway Data: {}", e.getMessage());
            return gatewayData;
        }

        return gatewayData;
    }

    public GatewayData2 parseGatewayData2 (String line) {
        GatewayData2 gatewayData2 = new GatewayData2();

        try {
            gatewayData2.setTransactionCode(line.substring(0, 2));
            gatewayData2.setTransactionCodeQualifier(line.substring(2, 3));
            gatewayData2.setTransactionComponentSequenceNumber(line.substring(3, 4));
            gatewayData2.setUcafStatusUcafCollectionIndicator(line.substring(4, 5));
            gatewayData2.setDinersDiscoverNetworkInformation(line.substring(5, 34));
            gatewayData2.setDinersDiscoverTransactionQualifier(line.substring(34, 80));
            gatewayData2.setGatewayTransactionIdentifier(line.substring(80, 95));
            gatewayData2.setResponseDataMerchantAdviceCode(line.substring(95, 99));
            gatewayData2.setMcAmexDiscoverDataCodes(line.substring(99, 112));
            gatewayData2.setMcAVVVerificationProgramProtocol(line.substring(112, 113));
            gatewayData2.setMastercardAVVVerificationDirectoryServerTransactionID(line.substring(113, 149));
            gatewayData2.setTransitTransactionTypeIndicator(line.substring(149, 151));
            gatewayData2.setTransportationModeIndicator(line.substring(151, 153));
            gatewayData2.setCavvValuePosition4(line.substring(153, 157));
            gatewayData2.setMerchantPaymentGatewayID(line.substring(157, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Gateway Data 2: {}", e.getMessage());
            return gatewayData2;
        }

        return gatewayData2;
    }

    public SupplementalData parseSupplementalData(String line) {
        SupplementalData supplementalData = new SupplementalData();

        try {
            supplementalData.setTransactionCode(line.substring(0, 2));
            supplementalData.setTransactionCodeQualifier(line.substring(2, 3));
            supplementalData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            supplementalData.setSurchargeAmount(line.substring(4, 12));
            supplementalData.setSurchargeCreditDebitIndicator(line.substring(12, 13));
            supplementalData.setDynamicCurrencyConversionCCCIndicator(line.substring(13, 14));
            supplementalData.setCashbackAmount(line.substring(14, 23));
            supplementalData.setAcquirerMerchantID(line.substring(23, 38));
            supplementalData.setTokenAssuranceMethod(line.substring(38, 40));
            supplementalData.setTokenRequestorID(line.substring(40, 51));
            supplementalData.setPanAccountRange(line.substring(51, 70));
            supplementalData.setRegulatedNonRegulatedStatus(line.substring(70, 71));
            supplementalData.setAgentUniqueID(line.substring(71, 76));
            supplementalData.setCavvVersionAndAuthenticationAction(line.substring(76, 78));
            supplementalData.setPaymentAccountReferenceNumberPAR(line.substring(78, 107));
            supplementalData.setBusinessApplicationIdentifierBAI(line.substring(107, 109));
            supplementalData.setMerchantTaxID(line.substring(109, 124));
            supplementalData.setSpecialConditionIndicator(line.substring(124, 125));
            supplementalData.setMastercardUCAFData(line.substring(125, 157));
            supplementalData.setMultipleClearingSequenceNumber(line.substring(157, 159));
            supplementalData.setMultipleClearingSequenceCount(line.substring(159, 161));
            supplementalData.setAdditionalTokenResponseInformation(line.substring(161, 162));
            supplementalData.setMerchantToAcquirerRouting(line.substring(162, 163));
            supplementalData.setMerchantVolumeIndicator(line.substring(163, 165));
            supplementalData.setForeignRetailerIndicator(line.substring(165, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Supplemental Data: {}", e.getMessage());
            return supplementalData;
        }

        return supplementalData;
    }

    public ArgentinaDomesticProcessing parseArgentinaDomesticProcessing(String line) {
        ArgentinaDomesticProcessing argentinaDomesticProcessing = new ArgentinaDomesticProcessing();

        try {
            argentinaDomesticProcessing.setTransactionCode(line.substring(0, 2));
            argentinaDomesticProcessing.setTransactionCodeQualifier(line.substring(2, 3));
            argentinaDomesticProcessing.setTransactionComponentSequenceNumber(line.substring(3, 4));
            argentinaDomesticProcessing.setCountryCode(line.substring(4, 7));
            argentinaDomesticProcessing.setPurchaseReceiptNumber(line.substring(7, 15));
            argentinaDomesticProcessing.setLocalDate(line.substring(15, 21));
            argentinaDomesticProcessing.setInstallmentType(line.substring(21, 23));
            argentinaDomesticProcessing.setNumberOfInstallments(line.substring(23, 25));
            argentinaDomesticProcessing.setInstallmentAmount(line.substring(25, 37));
            argentinaDomesticProcessing.setConsumerDeferredSale(line.substring(37, 43));
            argentinaDomesticProcessing.setInterestRateAmount(line.substring(43, 55));
            argentinaDomesticProcessing.setReserved(line.substring(55, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Argentina Domestic Processing: {}", e.getMessage());
            return argentinaDomesticProcessing;
        }

        return argentinaDomesticProcessing;
    }

    public BrazilNationalData parseBrazilNationalData(String line) {
        BrazilNationalData brazilNationalData = new BrazilNationalData();

        try {
            brazilNationalData.setTransactionCode(line.substring(0, 2));
            brazilNationalData.setTransactionCodeQualifier(line.substring(2, 3));
            brazilNationalData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            brazilNationalData.setCountryCode(line.substring(4, 7));
            brazilNationalData.setTotalAmount(line.substring(7, 19));
            brazilNationalData.setCurrencyCode(line.substring(19, 22));
            brazilNationalData.setNumberOfInstallments(line.substring(22, 25));
            brazilNationalData.setAmountOfEachInstallment(line.substring(25, 37));
            brazilNationalData.setInstallmentPaymentNumber(line.substring(37, 40));
            brazilNationalData.setFrequencyOfInstallments(line.substring(40, 41));
            brazilNationalData.setDateOfFirstInstallment(line.substring(41, 47));
            brazilNationalData.setTotalAmountFunded(line.substring(47, 59));
            brazilNationalData.setPercentOfAmountRequested(line.substring(59, 63));
            brazilNationalData.setTotalExpenses(line.substring(63, 75));
            brazilNationalData.setPercentOfTotalExpense(line.substring(75, 79));
            brazilNationalData.setTotalFees(line.substring(79, 91));
            brazilNationalData.setPercentOfTotalFees(line.substring(91, 95));
            brazilNationalData.setTotalTaxes(line.substring(95, 107));
            brazilNationalData.setPercentOfTotalTaxes(line.substring(107, 111));
            brazilNationalData.setTotalInsurance(line.substring(111, 123));
            brazilNationalData.setPercentOfTotalInsurance(line.substring(123, 127));
            brazilNationalData.setTotalOtherCosts(line.substring(127, 139));
            brazilNationalData.setPercentOfTotalOtherCosts(line.substring(139, 143));
            brazilNationalData.setMonthlyInterestRate(line.substring(143, 150));
            brazilNationalData.setAnnualInterestRate(line.substring(150, 157));
            brazilNationalData.setAnnualTotalCostOfFinancing(line.substring(157, 164));
            brazilNationalData.setInstallmentPaymentType(line.substring(164, 165));
            brazilNationalData.setReserved(line.substring(165, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Brazil National Data: {}", e.getMessage());
            return brazilNationalData;
        }

        return brazilNationalData;
    }

    public DomesticProcessingChileNationalData parseDomesticProcessingChileNationalData(String line) {
        DomesticProcessingChileNationalData chileNationalData = new DomesticProcessingChileNationalData();

        try {
            chileNationalData.setTransactionCode(line.substring(0, 2));
            chileNationalData.setTransactionCodeQualifier(line.substring(2, 3));
            chileNationalData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            chileNationalData.setCountryCode(line.substring(4, 7));
            chileNationalData.setTotalPurchaseAmount(line.substring(7, 19));
            chileNationalData.setNumberOfInstallments(line.substring(19, 22));
            chileNationalData.setInstallmentType(line.substring(22, 23));
            chileNationalData.setInstallmentAmount(line.substring(23, 35));
            chileNationalData.setTransactionInterestRate(line.substring(35, 39));
            chileNationalData.setDeferredPeriod(line.substring(39, 40));
            chileNationalData.setSimulationFlag(line.substring(40, 41));
            chileNationalData.setIssuerGracePeriodFlag(line.substring(41, 42));
            chileNationalData.setMerchantGracePeriod(line.substring(42, 43));
            chileNationalData.setDeferredPeriodSimulationFlag(line.substring(43, 44));
            chileNationalData.setReservedForAnnualEquivalentChargeRateCAE(line.substring(44, 49));
            chileNationalData.setDomesticECommerceTool(line.substring(49, 50));
            chileNationalData.setDomesticECommerceToolData(line.substring(50, 70));
            chileNationalData.setReserved(line.substring(70, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Domestic Processing Chile National Data: {}", e.getMessage());
            return chileNationalData;
        }

        return chileNationalData;
    }

    public ProcessingUruguayNationalData parseUruguayDomesticProcessing(String line) {
        ProcessingUruguayNationalData uruguayDomesticProcessing = new ProcessingUruguayNationalData();

        try {
            uruguayDomesticProcessing.setTransactionCode(line.substring(0, 2));
            uruguayDomesticProcessing.setTransactionCodeQualifier(line.substring(2, 3));
            uruguayDomesticProcessing.setTransactionComponentSequenceNumber(line.substring(3, 4));
            uruguayDomesticProcessing.setMonthsDeferred(line.substring(4, 5));
            uruguayDomesticProcessing.setReserved1(line.substring(5, 6));
            uruguayDomesticProcessing.setInvoiceAmount(line.substring(6, 18));
            uruguayDomesticProcessing.setTaxBenefitTotalAmount(line.substring(18, 30));
            uruguayDomesticProcessing.setAmountBeforeDiscountTransactionOriginalAmount(line.substring(30, 42));
            uruguayDomesticProcessing.setBaseAmountForTaxBenefitsCalculation(line.substring(42, 54));
            uruguayDomesticProcessing.setBasisPointsAppliedByTheLaw(line.substring(54, 58));
            uruguayDomesticProcessing.setMerchantsInvoiceSerialNumber(line.substring(58, 67));
            uruguayDomesticProcessing.setFiscalBenefitsRetentionAgent(line.substring(67, 68));
            uruguayDomesticProcessing.setOrderNumber(line.substring(68, 93));
            uruguayDomesticProcessing.setPromotionCode(line.substring(93, 105));
            uruguayDomesticProcessing.setCardholderIDForRecurringPayments(line.substring(105, 118));
            uruguayDomesticProcessing.setAnnualTotalCostOfFinancing(line.substring(118, 125));
            uruguayDomesticProcessing.setInstallmentPaymentInterest(line.substring(125, 137));
            uruguayDomesticProcessing.setLawIdentification(line.substring(137, 139));
            uruguayDomesticProcessing.setBillingPeriodMCRecurringTransaction(line.substring(139, 144));
            uruguayDomesticProcessing.setReferenceNumberMCRecurringTransaction(line.substring(144, 156));
            uruguayDomesticProcessing.setVatRate(line.substring(156, 160));
            uruguayDomesticProcessing.setFloorLimitAppliedByTaxBenefitLaw(line.substring(160, 161));
            uruguayDomesticProcessing.setReserved2(line.substring(161, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Uruguay Domestic Processing: {}", e.getMessage());
            return uruguayDomesticProcessing;
        }

        return uruguayDomesticProcessing;
    }

    public IntraCountryDataColombia parseIntraCountryDataColombia(String line) {
        IntraCountryDataColombia columbiaNationalData = new IntraCountryDataColombia();

        try {
            columbiaNationalData.setTransactionCode(line.substring(0, 2));
            columbiaNationalData.setTransactionCodeQualifier(line.substring(2, 3));
            columbiaNationalData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            columbiaNationalData.setCountryCode(line.substring(4, 7));
            columbiaNationalData.setNationalNetDomesticTokenData(line.substring(7, 130));
            columbiaNationalData.setMastercardInstallmentCustomerID(line.substring(130, 141));
            columbiaNationalData.setMastercardPurchaseCardIssuerData(line.substring(141, 160));
            columbiaNationalData.setMastercardPurchaseAmountGratuity(line.substring(160, 162));
            columbiaNationalData.setMastercardPurchaseAcquirerOriginalProcessingCode(line.substring(162, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Intra Country Data Colombia: {}", e.getMessage());
            return columbiaNationalData;
        }

        return columbiaNationalData;
    }

    public IntraCountryDataIndia parseIntraCountryDataIndia(String line) {
        IntraCountryDataIndia indiaNationalData = new IntraCountryDataIndia();

        try {
            indiaNationalData.setTransactionCode(line.substring(0, 2));
            indiaNationalData.setTransactionCodeQualifier(line.substring(2, 3));
            indiaNationalData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            indiaNationalData.setSiType(line.substring(4, 5));
            indiaNationalData.setTransactionType(line.substring(5, 6));
            indiaNationalData.setValidationFlag(line.substring(6, 7));
            indiaNationalData.setSiHubID(line.substring(7, 17));
            indiaNationalData.setNumberOfSiDebits(line.substring(17, 19));
            indiaNationalData.setFrequencyOfSi(line.substring(19, 20));
            indiaNationalData.setReserved(line.substring(20, 168));
        } catch (Exception e) {
            log.warn("Exception caught while parsing Intra Country Data India: {}", e.getMessage());
            return indiaNationalData;
        }

        return indiaNationalData;
    }

    public IntraCountryDataJapan parseIntraCountryDataJapan(String line) {
        IntraCountryDataJapan japanNationalData = new IntraCountryDataJapan();

        try {
            japanNationalData.setTransactionCode(line.substring(0, 2));
            japanNationalData.setTransactionCodeQualifier(line.substring(2, 3));
            japanNationalData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            japanNationalData.setCountryCode(line.substring(4, 7));
            japanNationalData.setNumberOfBonusPayments(line.substring(7, 8));
            japanNationalData.setBonusMonthSign(line.substring(8, 9));
            japanNationalData.setBonusAmount(line.substring(9, 13));
            japanNationalData.setNumberOfInstallmentPayments(line.substring(13, 16));
            japanNationalData.setPaymentMode(line.substring(16, 18));
            japanNationalData.setNetSalesAmount(line.substring(18, 26));
            japanNationalData.setTaxAndMailingCharge(line.substring(26, 34));
            japanNationalData.setSalesDraftReferenceNumber(line.substring(34, 51));
            japanNationalData.setAcquiringBankMerchantNumber(line.substring(51, 66));
            japanNationalData.setMerchantNameKatakana(line.substring(66, 89));
            japanNationalData.setMerchantNameKanji(line.substring(89, 129));
            japanNationalData.setTerminalIdentificationNumber(line.substring(129, 142));
            japanNationalData.setSalesSlipNumber(line.substring(142, 147));
            japanNationalData.setReserved(line.substring(153, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Intra Country Data Japan: {}", e.getMessage());
            return japanNationalData;
        }

        return japanNationalData;
    }
    public IntraCountryDataMexico parseIntraCountryDataMexico(String line) {
        IntraCountryDataMexico mexicoNationalData = new IntraCountryDataMexico();

        try {
            mexicoNationalData.setTransactionCode(line.substring(0, 2));
            mexicoNationalData.setTransactionCodeQualifier(line.substring(2, 3));
            mexicoNationalData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            mexicoNationalData.setCountryCode(line.substring(4, 7));
            mexicoNationalData.setOriginalAuthorizationCode(line.substring(7, 13));
            mexicoNationalData.setReserved(line.substring(13, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Intra Country Data Mexico: {}", e.getMessage());
            return mexicoNationalData;
        }

        return mexicoNationalData;
    }

    public IntraCountryDataSouthAfrica parseIntraCountryDataSouthAfrica(String line) {
        IntraCountryDataSouthAfrica southAfricaNationalData = new IntraCountryDataSouthAfrica();

        try {
            southAfricaNationalData.setTransactionCode(line.substring(0, 2));
            southAfricaNationalData.setTransactionCodeQualifier(line.substring(2, 3));
            southAfricaNationalData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            southAfricaNationalData.setCountryCode(line.substring(4, 7));
            southAfricaNationalData.setBudget(line.substring(7, 9));
            southAfricaNationalData.setReserved(line.substring(9, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Intra Country Data South Africa: {}", e.getMessage());
            return southAfricaNationalData;
        }

        return southAfricaNationalData;
    }

    public CurrencyConversion parseCurrencyConversion(String line) {
        CurrencyConversion currencyConversion = new CurrencyConversion();

        try {
            currencyConversion.setTransactionCode(line.substring(0, 2));
            currencyConversion.setTransactionCodeQualifier(line.substring(2, 3));
            currencyConversion.setTransactionComponentSequenceNumber(line.substring(3, 4));
            currencyConversion.setCurrencyConversionReferenceIdentifierNumber(line.substring(4, 64));
            currencyConversion.setCurrencyConversionOriginalPriceAmount(line.substring(64, 82));
            currencyConversion.setCurrencyConversionOriginalDecimalPositionsIndicator(line.substring(82, 84));
            currencyConversion.setCurrencyConversionOriginalPriceCurrencyCode(line.substring(84, 87));
            currencyConversion.setCurrencyConversionFXRateCurrencyConversionRate(line.substring(87, 103));
            currencyConversion.setCurrencyConversionCurrencyConversionTimestamp(line.substring(103, 113));
            currencyConversion.setReserved(line.substring(113, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Currency Conversion: {}", e.getMessage());
            return currencyConversion;
        }

        return currencyConversion;
    }

    public GatewayData3 parseGatewayData3(String line) {
        GatewayData3 gatewayData = new GatewayData3();

        try {
            gatewayData.setTransactionCode(line.substring(0, 2));
            gatewayData.setTransactionCodeQualifier(line.substring(2, 3));
            gatewayData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            gatewayData.setAmericanExpressSellerTelephoneNumber(line.substring(4, 24));
            gatewayData.setAmericanExpressSellerEmailAddress(line.substring(24, 64));
            gatewayData.setAmericanExpressSellerID(line.substring(64, 84));
            gatewayData.setAmericanExpressLast4PANReturnIndicator(line.substring(84, 85));
            gatewayData.setAmericanExpressPANExtended(line.substring(85, 108));
            gatewayData.setAmericanExpressSellerName(line.substring(108, 146));
            gatewayData.setMerchantConsumerTransactionIndicator(line.substring(146, 147));
            gatewayData.setAmericanExpressMobileDeviceType(line.substring(147, 149));
            gatewayData.setAmexExpressPANExtendedResponseCode(line.substring(149, 150));
            gatewayData.setAmericanExpressFunctionCode(line.substring(150, 153));
            gatewayData.setReserved(line.substring(153, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Gateway Data 3: {}", e.getMessage());
            return gatewayData;
        }

        return gatewayData;
    }

    public EMVData parseEMVData(String line) {
        EMVData emvData = new EMVData();

        try {
            emvData.setTransactionCode(line.substring(0, 2));
            emvData.setTransactionCodeQualifier(line.substring(2, 3));
            emvData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            emvData.setDestinationIdentifier(line.substring(4, 10));
            emvData.setSourceIdentifier(line.substring(10, 16));
            emvData.setTc33ApplicationCode(line.substring(16, 20));
            emvData.setMessageIdentifier(line.substring(20, 35));
            emvData.setTransactionType(line.substring(35, 37));
            emvData.setCardSequenceNumber(line.substring(37, 40));
            emvData.setTerminalTransactionDate(line.substring(40, 46));
            emvData.setTerminalCapabilityProfile(line.substring(46, 52));
            emvData.setTerminalCountryCode(line.substring(52, 55));
            emvData.setUnpredictableNumber(line.substring(55, 63));
            emvData.setApplicationTransactionCounter(line.substring(63, 67));
            emvData.setApplicationInterchangeProfile(line.substring(67, 71));
            emvData.setApplicationCryptogram(line.substring(71, 87));
            emvData.setTerminalVerificationResults(line.substring(87, 97));
            emvData.setAmountAuthorized(line.substring(97, 109));
            emvData.setFormFactorIndicator(line.substring(109, 117));
            emvData.setDedicatedFileNameApplicationID_AID(line.substring(117, 149));
            emvData.setTapToPhoneIndicator(line.substring(149, 150));
            emvData.setReserved(line.substring(150, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing EMV Data: {}", e.getMessage());
            return emvData;
        }

        return emvData;
    }

    public EMVData2 parseEMVData2(String line) {
        EMVData2 emvContinuationData = new EMVData2();

        try {
            emvContinuationData.setTransactionCode(line.substring(0, 2));
            emvContinuationData.setTransactionCodeQualifier(line.substring(2, 3));
            emvContinuationData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            emvContinuationData.setIssuerApplicationData(line.substring(4, 68));

            emvContinuationData.setIssuerScript1Results(line.substring(68, 78));
            emvContinuationData.setCryptogramInformationDataCID(line.substring(78, 80));
            emvContinuationData.setCardholderVerificationMethodCVMResults(line.substring(80, 86));
            emvContinuationData.setTerminalApplicationVersionNumber(line.substring(86, 90));
            emvContinuationData.setTransactionSequenceCounter(line.substring(90, 98));
            emvContinuationData.setApplicationUsageControl(line.substring(98, 102));
            emvContinuationData.setApplicationIdentifierAIDTerminal(line.substring(102, 134));
            emvContinuationData.setIssuerAuthenticationData(line.substring(134, 166));
            emvContinuationData.setReserved(line.substring(166, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing EMV Data 2: {}", e.getMessage());
            return emvContinuationData;
        }

        return emvContinuationData;
    }

    public LodgingSummary parseLodgingSummary(String line) {
        LodgingSummary lodgingData = new LodgingSummary();

        try {
            lodgingData.setTransactionCode(line.substring(0, 2));
            lodgingData.setTransactionCodeQualifier(line.substring(2, 3));
            lodgingData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            lodgingData.setDestinationIdentifier(line.substring(4, 10));
            lodgingData.setSourceIdentifier(line.substring(10, 16));
            lodgingData.setTc33ApplicationCode(line.substring(16, 20));
            lodgingData.setMessageIdentifier(line.substring(20, 35));
            lodgingData.setCheckInDate(line.substring(35, 41));
            lodgingData.setCheckOutDate(line.substring(41, 47));
            lodgingData.setDailyRoomRate1(line.substring(47, 55));
            lodgingData.setDailyRoomNights1(line.substring(55, 59));
            lodgingData.setCustomerServiceTollFreeNumber(line.substring(59, 76));
            lodgingData.setSpecialProgramCode(line.substring(76, 77));
            lodgingData.setTravelAgencyCode(line.substring(77, 85));
            lodgingData.setTravelAgencyName(line.substring(85, 110));
            lodgingData.setRoomServiceCharges(line.substring(110, 122));
            lodgingData.setMiniBarCharges(line.substring(122, 134));
            lodgingData.setInternetAccessCharges(line.substring(134, 146));
            lodgingData.setFireSafetyIndicator(line.substring(146, 147));
            lodgingData.setReserved(line.substring(147, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Lodging Summary: {}", e.getMessage());
            return lodgingData;
        }

        return lodgingData;
    }

    public LodgingSummary2 parseLodgingSummary2(String line) {
        LodgingSummary2 lodgingContinuationData = new LodgingSummary2();

        try {
            lodgingContinuationData.setTransactionCode(line.substring(0, 2));
            lodgingContinuationData.setTransactionCodeQualifier(line.substring(2, 3));
            lodgingContinuationData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            lodgingContinuationData.setDailyRoomRate2(line.substring(4, 12));
            lodgingContinuationData.setDailyRoomNights2(line.substring(12, 16));
            lodgingContinuationData.setDailyRoomRate3(line.substring(16, 24));
            lodgingContinuationData.setDailyRoomNights3(line.substring(24, 28));
            lodgingContinuationData.setGuestName(line.substring(28, 68));
            lodgingContinuationData.setReserved(line.substring(68, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Lodging Summary 2: {}", e.getMessage());
            return lodgingContinuationData;
        }

        return lodgingContinuationData;
    }

    public LodgingSummary3 parseLodgingSummary3(String line) {
        LodgingSummary3 lodgingSummary = new LodgingSummary3();

        try {
            lodgingSummary.setTransactionCode(line.substring(0, 2));
            lodgingSummary.setTransactionCodeQualifier(line.substring(2, 3));
            lodgingSummary.setTransactionComponentSequenceNumber(line.substring(3, 4));
            lodgingSummary.setSmokingPreference(line.substring(4, 5));
            lodgingSummary.setNumberOfRoomsBooked(line.substring(5, 7));
            lodgingSummary.setNumberOfAdults(line.substring(7, 9));
            lodgingSummary.setBedType(line.substring(9, 21));
            lodgingSummary.setTaxElements(line.substring(21, 31));
            lodgingSummary.setRateType(line.substring(31, 43));
            lodgingSummary.setCorporateClientCode(line.substring(43, 60));
            lodgingSummary.setPromotionalCode(line.substring(60, 72));
            lodgingSummary.setAdditionalCoupon(line.substring(72, 84));
            lodgingSummary.setRoomLocation(line.substring(84, 94));
            lodgingSummary.setReserved(line.substring(94, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Lodging Summary 3: {}", e.getMessage());
            return lodgingSummary;
        }

        return lodgingSummary;
    }

    public LodgingAdditionalAmounts parseLodgingAdditionalAmounts(String line) {
        LodgingAdditionalAmounts lodgingAdditionalAmountsData = new LodgingAdditionalAmounts();

        try {
            lodgingAdditionalAmountsData.setTransactionCode(line.substring(0, 2));
            lodgingAdditionalAmountsData.setTransactionCodeQualifier(line.substring(2, 3));
            lodgingAdditionalAmountsData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            lodgingAdditionalAmountsData.setTotalTax(line.substring(4, 16));
            lodgingAdditionalAmountsData.setFoodAndBeverageCharges(line.substring(16, 28));
            lodgingAdditionalAmountsData.setTotalRoomTax(line.substring(28, 40));
            lodgingAdditionalAmountsData.setAdjustmentAmount(line.substring(40, 52));
            lodgingAdditionalAmountsData.setPhoneCharges(line.substring(52, 64));
            lodgingAdditionalAmountsData.setRestaurantCharges(line.substring(64, 76));
            lodgingAdditionalAmountsData.setLaundryCharges(line.substring(76, 88));
            lodgingAdditionalAmountsData.setMovieCharges(line.substring(88, 100));
            lodgingAdditionalAmountsData.setLoungeBarCharges(line.substring(100, 112));
            lodgingAdditionalAmountsData.setEarlyDepartureCharges(line.substring(112, 124));
            lodgingAdditionalAmountsData.setPrepaidExpenses(line.substring(124, 136));
            lodgingAdditionalAmountsData.setOtherCharges(line.substring(136, 148));
            lodgingAdditionalAmountsData.setGiftShopCharges(line.substring(148, 160));
            lodgingAdditionalAmountsData.setReserved(line.substring(160, 168));

        }catch (Exception e) {
            log.warn("Exception caught while parsing Lodging Additional Amounts: {}", e.getMessage());
            return lodgingAdditionalAmountsData;
        }

        return lodgingAdditionalAmountsData;
    }

    public LodgingAdditionalAmounts2 parseLodgingAdditionalAmounts2(String line) {
        LodgingAdditionalAmounts2 lodgingAdditionalAmountsContinuationData = new LodgingAdditionalAmounts2();

        try {
            lodgingAdditionalAmountsContinuationData.setTransactionCode(line.substring(0, 2));
            lodgingAdditionalAmountsContinuationData.setTransactionCodeQualifier(line.substring(2, 3));
            lodgingAdditionalAmountsContinuationData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            lodgingAdditionalAmountsContinuationData.setHealthClubCharges(line.substring(4, 16));
            lodgingAdditionalAmountsContinuationData.setValetParkingCharges(line.substring(16, 28));
            lodgingAdditionalAmountsContinuationData.setCashDisbursementCharges(line.substring(28, 40));
            lodgingAdditionalAmountsContinuationData.setNonRoomCharges(line.substring(40, 52));
            lodgingAdditionalAmountsContinuationData.setBusinessCenterCharges(line.substring(52, 64));
            lodgingAdditionalAmountsContinuationData.setTransportationCharges(line.substring(64, 76));
            lodgingAdditionalAmountsContinuationData.setGratuityCharges(line.substring(76, 88));
            lodgingAdditionalAmountsContinuationData.setConferenceRoomCharges(line.substring(88, 100));
            lodgingAdditionalAmountsContinuationData.setAudioVisualCharges(line.substring(100, 112));
            lodgingAdditionalAmountsContinuationData.setBanquetCharges(line.substring(112, 124));
            lodgingAdditionalAmountsContinuationData.setTotalNonRoomTaxAmount(line.substring(124, 136));
            lodgingAdditionalAmountsContinuationData.setReserved(line.substring(136, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Lodging Additional Amounts 2: {}", e.getMessage());
            return lodgingAdditionalAmountsContinuationData;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Lodging Additional Amounts 2: {}", e.getMessage());
            return lodgingAdditionalAmountsContinuationData;
        }

        return lodgingAdditionalAmountsContinuationData;
    }

    public LevelTwoData parseLevelTwoData(String line) {
        LevelTwoData levelIIData = new LevelTwoData();

        try {
            levelIIData.setTransactionCode(line.substring(0, 2));
            levelIIData.setTransactionCodeQualifier(line.substring(2, 3));
            levelIIData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            levelIIData.setDestinationIdentifier(line.substring(4, 10));
            levelIIData.setSourceIdentifier(line.substring(10, 16));
            levelIIData.setTc33ApplicationCode(line.substring(16, 20));
            levelIIData.setMessageIdentifier(line.substring(20, 35));
            levelIIData.setLocalTax(line.substring(35, 47));
            levelIIData.setLocalTaxIncluded(line.substring(47, 48));
            levelIIData.setNationalTax(line.substring(48, 60));
            levelIIData.setNationalTaxIncluded(line.substring(60, 61));
            levelIIData.setCustomerCodeCustomerReferenceIdentifierCRI(line.substring(61, 78));
            levelIIData.setMerchantVatRegistrationSingleBusinessReferenceNumber(line.substring(78, 98));
            levelIIData.setReserved(line.substring(98, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Level II Data: {}", e.getMessage());
            return levelIIData;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Level II Data: {}", e.getMessage());
            return levelIIData;
        }

        return levelIIData;
    }

    public LevelTwoDataAmericanExpress parseLevelTwoDataAmericanExpress(String line) {
        LevelTwoDataAmericanExpress amexLevelIIData = new LevelTwoDataAmericanExpress();

        try {
            amexLevelIIData.setTransactionCode(line.substring(0, 2));
            amexLevelIIData.setTransactionCodeQualifier(line.substring(2, 3));
            amexLevelIIData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            amexLevelIIData.setAmericanExpressChargeDescriptor1(line.substring(4, 44));
            amexLevelIIData.setAmericanExpressChargeDescriptor2(line.substring(44, 84));
            amexLevelIIData.setAmericanExpressChargeDescriptor3(line.substring(84, 124));
            amexLevelIIData.setAmericanExpressChargeDescriptor4(line.substring(124, 164));
            amexLevelIIData.setAmericanExpressTaxTypeCode(line.substring(164, 167));
            amexLevelIIData.setReserved(line.substring(167, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Level II Data American Express: {}", e.getMessage());
            return amexLevelIIData;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Level II Data American Express: {}", e.getMessage());
            return amexLevelIIData;
        }

        return amexLevelIIData;
    }

    public LevelThreeDataPurchasingTransactionSummary parseLevelThreeDataPurchasingTransactionSummary(String line) {
        LevelThreeDataPurchasingTransactionSummary levelIIIData = new LevelThreeDataPurchasingTransactionSummary();

        try {
            levelIIIData.setTransactionCode(line.substring(0, 2));
            levelIIIData.setTransactionCodeQualifier(line.substring(2, 3));
            levelIIIData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            levelIIIData.setDiscountAmount(line.substring(4, 16));
            levelIIIData.setDiscountAmountSignage(line.substring(16, 17));
            levelIIIData.setFreightShippingAmount(line.substring(17, 29));
            levelIIIData.setFreightShippingAmountSignage(line.substring(29, 30));
            levelIIIData.setDutyAmount(line.substring(30, 42));
            levelIIIData.setDutyAmountSignage(line.substring(42, 43));
            levelIIIData.setVatTaxAmount(line.substring(43, 55));
            levelIIIData.setVatTaxAmountSignage(line.substring(55, 56));
            levelIIIData.setUniqueVatInvoiceRefNumber(line.substring(56, 71));
            levelIIIData.setOrderDate(line.substring(71, 77));
            levelIIIData.setVatTaxRateFreightShipping(line.substring(77, 81));
            levelIIIData.setSummaryCommodityCode(line.substring(81, 85));
            levelIIIData.setInvoiceLevelDiscountTreatment(line.substring(85, 86));
            levelIIIData.setTaxTreatment(line.substring(86, 87));
            levelIIIData.setMastercardCardAcceptorReferenceNumber(line.substring(87, 112));
            levelIIIData.setMastercardCardAcceptorVatNumber(line.substring(112, 132));
            levelIIIData.setMastercardCustomerVatNumber(line.substring(132, 152));
            levelIIIData.setReserved(line.substring(152, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Level III Data Purchasing Transaction Summary: {}", e.getMessage());
            return levelIIIData;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Level III Data Purchasing Transaction Summary: {}", e.getMessage());
            return levelIIIData;
        }

        return levelIIIData;
    }

    public LevelThreeDataPurchasingTransactionSummary2 parseLevelThreeDataPurchasingTransactionSummary2(String line) {
        LevelThreeDataPurchasingTransactionSummary2 levelIIIDataContinuation = new LevelThreeDataPurchasingTransactionSummary2();

        try {
            levelIIIDataContinuation.setTransactionCode(line.substring(0, 2));
            levelIIIDataContinuation.setTransactionCodeQualifier(line.substring(2, 3));
            levelIIIDataContinuation.setTransactionComponentSequenceNumber(line.substring(3, 4));
            levelIIIDataContinuation.setMastercardAuthorizedContactName(line.substring(4, 40));
            levelIIIDataContinuation.setMcContactName(line.substring(40, 80));
            levelIIIDataContinuation.setReserved(line.substring(80, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Level III Data Purchasing Transaction Summary 2: {}", e.getMessage());
            return levelIIIDataContinuation;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Level III Data Purchasing Transaction Summary 2: {}", e.getMessage());
            return levelIIIDataContinuation;
        }

        return levelIIIDataContinuation;
    }

    public PassengerItineraryData parsePassengerItineraryData(String line) {
        PassengerItineraryData passengerItineraryData = new PassengerItineraryData();

        try {
            passengerItineraryData.setTransactionCode(line.substring(0, 2));
            passengerItineraryData.setTransactionCodeQualifier(line.substring(2, 3));
            passengerItineraryData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            passengerItineraryData.setDestinationIdentifier(line.substring(4, 10));
            passengerItineraryData.setSourceIdentifier(line.substring(10, 16));
            passengerItineraryData.setTc33ApplicationCode(line.substring(16, 20));
            passengerItineraryData.setMessageIdentifier(line.substring(20, 35));
            passengerItineraryData.setPassengerName(line.substring(35, 55));
            passengerItineraryData.setDepartureDate(line.substring(55, 61));
            passengerItineraryData.setOriginationCityAirportCode(line.substring(61, 64));
            passengerItineraryData.setTravelAgencyCode(line.substring(64, 72));
            passengerItineraryData.setTravelAgencyName(line.substring(72, 97));
            passengerItineraryData.setRestrictedTicketIndicator(line.substring(97, 98));
            passengerItineraryData.setComputerizedReservationSystem(line.substring(98, 102));
            passengerItineraryData.setTicketNumber(line.substring(102, 117));
            passengerItineraryData.setTotalClearingAmount(line.substring(117, 137));
            passengerItineraryData.setCustomerCode(line.substring(137, 162));
            passengerItineraryData.setMultipleClearingSequenceNumber(line.substring(162, 164));
            passengerItineraryData.setMultipleClearingSequenceCount(line.substring(164, 166));
            passengerItineraryData.setReserved(line.substring(166, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Passenger Itinerary Data: {}", e.getMessage());
            return passengerItineraryData;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Passenger Itinerary Data: {}", e.getMessage());
            return passengerItineraryData;
        }

        return passengerItineraryData;
    }

    public PassengerItineraryData2 parsePassengerItineraryData2(String line) {
        PassengerItineraryData2 passengerItineraryContinuationData = new PassengerItineraryData2();

        try {
            passengerItineraryContinuationData.setTransactionCode(line.substring(0, 2));
            passengerItineraryContinuationData.setTransactionCodeQualifier(line.substring(2, 3));
            passengerItineraryContinuationData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            passengerItineraryContinuationData.setTotalFareAmount(line.substring(4, 23));
            passengerItineraryContinuationData.setTotalTaxesAmount(line.substring(23, 42));

            passengerItineraryContinuationData.setTotalFeeAmount(line.substring(42, 62));
            passengerItineraryContinuationData.setCreditReasonIndicator(line.substring(62, 63));
            passengerItineraryContinuationData.setTicketChangeIndicator(line.substring(63, 64));
            passengerItineraryContinuationData.setReserved(line.substring(64, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Passenger Itinerary Data 2: {}", e.getMessage());
            return passengerItineraryContinuationData;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Passenger Itinerary Data 2: {}", e.getMessage());
            return passengerItineraryContinuationData;
        }

        return passengerItineraryContinuationData;
    }

    public PassengerItineraryData3 parsePassengerItineraryData3(String line) {
        PassengerItineraryData3 passengerItineraryData = new PassengerItineraryData3();

        try {
            passengerItineraryData.setTransactionCode(line.substring(0, 2));
            passengerItineraryData.setTransactionCodeQualifier(line.substring(2, 3));
            passengerItineraryData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            passengerItineraryData.setTripLeg1Information(line.substring(4, 11));
            passengerItineraryData.setCarrierCode(line.substring(5, 7));
            passengerItineraryData.setServiceClass(line.substring(7, 8));
            passengerItineraryData.setStopOverCode(line.substring(8, 9));
            passengerItineraryData.setDestinationCityAirport(line.substring(9, 12));
            passengerItineraryData.setFareBasisCode_Leg1(line.substring(11, 17));
            passengerItineraryData.setFlightNumber_Leg1(line.substring(17, 22));
            passengerItineraryData.setDepartureDate_Leg1(line.substring(22, 28));
            passengerItineraryData.setDepartureTime_Leg1(line.substring(28, 32));
            passengerItineraryData.setDepartureTimeSegment_Leg1(line.substring(32, 33));
            passengerItineraryData.setArrivalTime_Leg1(line.substring(33, 37));
            passengerItineraryData.setArrivalTimeSegment_Leg1(line.substring(37, 38));
            passengerItineraryData.setEndorsementRestrictions_Leg1(line.substring(38, 58));
            passengerItineraryData.setConjunctionTicket_Leg1(line.substring(58, 83));
            passengerItineraryData.setExchangeTicket_Leg1(line.substring(83, 108));
            passengerItineraryData.setCouponNumber_Leg1(line.substring(108, 109));
            passengerItineraryData.setFareAmount_Leg1(line.substring(109, 121));
            passengerItineraryData.setTaxAmount_Leg1(line.substring(121, 133));
            passengerItineraryData.setFeeAmount_Leg1(line.substring(133, 145));
            passengerItineraryData.setReserved(line.substring(145, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Passenger Itinerary Data 3: {}", e.getMessage());
            return passengerItineraryData;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Passenger Itinerary Data 3: {}", e.getMessage());
            return passengerItineraryData;
        }

        return passengerItineraryData;
    }

    public PassengerItineraryData4 parsePassengerItineraryData4(String line) {
        PassengerItineraryData4 passengerItineraryData = new PassengerItineraryData4();

        try {
            passengerItineraryData.setTransactionCode(line.substring(0, 2));
            passengerItineraryData.setTransactionCodeQualifier(line.substring(2, 3));
            passengerItineraryData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            passengerItineraryData.setCarrierCode(line.substring(4, 6));
            passengerItineraryData.setServiceClass(line.substring(6, 7)); // Position 7 (Length 1)
            passengerItineraryData.setStopOverCode(line.substring(7, 8)); // Position 8 (Length 1)
            passengerItineraryData.setDestinationCityAirport(line.substring(8, 11)); // Position 9-11 (Length 3)
            // Fields that follow
            passengerItineraryData.setFareBasisCode_Leg2(line.substring(11, 17)); // Position 12-17 (Length 6)
            passengerItineraryData.setFlightNumber_Leg2(line.substring(17, 22)); // Position 18-22 (Length 5)
            passengerItineraryData.setDepartureDate_Leg2(line.substring(22, 28)); // Position 23-28 (Length 6)
            passengerItineraryData.setDepartureTime_Leg2(line.substring(28, 32)); // Position 29-32 (Length 4)
            passengerItineraryData.setDepartureTimeSegment_Leg2(line.substring(32, 33)); // Position 33 (Length 1)
            passengerItineraryData.setArrivalTime_Leg2(line.substring(33, 37)); // Position 34-37 (Length 4)
            passengerItineraryData.setArrivalTimeSegment_Leg2(line.substring(37, 38)); // Position 38 (Length 1)
            passengerItineraryData.setEndorsementRestrictions_Leg2(line.substring(38, 58)); // Position 39-58 (Length 20)
            passengerItineraryData.setConjunctionTicket_Leg2(line.substring(58, 83)); // Position 59-83 (Length 25)
            passengerItineraryData.setExchangeTicket_Leg2(line.substring(83, 108));
            passengerItineraryData.setCouponNumber_Leg2(line.substring(108, 109));
            passengerItineraryData.setFareAmount_Leg2(line.substring(109, 121));
            passengerItineraryData.setTaxAmount_Leg2(line.substring(121, 133));
            passengerItineraryData.setFeeAmount_Leg2(line.substring(133, 145));
            passengerItineraryData.setReserved(line.substring(145, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Passenger Itinerary Data 4: {}", e.getMessage());
            return passengerItineraryData;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Passenger Itinerary Data 4: {}", e.getMessage());
            return passengerItineraryData;
        }

        return passengerItineraryData;
    }

    public PassengerItineraryData5 parsePassengerItineraryData5(String line) {
        PassengerItineraryData5 passengerItineraryContinuationData4 = new PassengerItineraryData5();

        try {
            passengerItineraryContinuationData4.setTransactionCode(line.substring(0, 2));
            passengerItineraryContinuationData4.setTransactionCodeQualifier(line.substring(2, 3));
            passengerItineraryContinuationData4.setTransactionComponentSequenceNumber(line.substring(3, 4));
            // Group Trip Leg 3 Information (Starts at position 5 - index 4)
            passengerItineraryContinuationData4.setCarrierCode(line.substring(4, 6)); // Position 5-6 (Length 2)
            passengerItineraryContinuationData4.setServiceClass(line.substring(6, 7)); // Position 7 (Length 1)
            passengerItineraryContinuationData4.setStopOverCode(line.substring(7, 8)); // Position 8 (Length 1)
            passengerItineraryContinuationData4.setDestinationCityAirport(line.substring(8, 11)); // Position 9-11 (Length 3)
            // Fields that follow
            passengerItineraryContinuationData4.setFareBasisCode_Leg3(line.substring(11, 17)); // Position 12-17 (Length 6)
            passengerItineraryContinuationData4.setFlightNumber_Leg3(line.substring(17, 22)); // Position 18-22 (Length 5)
            passengerItineraryContinuationData4.setDepartureDate_Leg3(line.substring(22, 28)); // Position 23-28 (Length 6)
            passengerItineraryContinuationData4.setDepartureTime_Leg3(line.substring(28, 32)); // Position 29-32 (Length 4)
            passengerItineraryContinuationData4.setDepartureTimeSegment_Leg3(line.substring(32, 33)); // Position 33 (Length 1)
            passengerItineraryContinuationData4.setArrivalTime_Leg3(line.substring(33, 37)); // Position 34-37 (Length 4)
            passengerItineraryContinuationData4.setArrivalTimeSegment_Leg3(line.substring(37, 38)); // Position 38 (Length 1)
            passengerItineraryContinuationData4.setEndorsementRestrictions_Leg3(line.substring(38, 58)); // Position 39-58 (Length 20)
            passengerItineraryContinuationData4.setConjunctionTicket_Leg3(line.substring(58, 83)); // Position 59-83 (Length 25)
            passengerItineraryContinuationData4.setExchangeTicket_Leg3(line.substring(83, 108)); // Position 84-108 (Length 25)
            passengerItineraryContinuationData4.setCouponNumber_Leg3(line.substring(108, 109)); // Position 109 (Length 1)
            passengerItineraryContinuationData4.setFareAmount_Leg3(line.substring(109, 121)); // Position 110-121 (Length 12)
            passengerItineraryContinuationData4.setTaxAmount_Leg3(line.substring(121, 133)); // Position 122-133 (Length 12)
            passengerItineraryContinuationData4.setFeeAmount_Leg3(line.substring(133, 145)); // Position 134-145 (Length 12)
            passengerItineraryContinuationData4.setReserved(line.substring(145, 168)); // Position 146-168 (Length 23)

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Passenger Itinerary Data 5: {}", e.getMessage());
            return passengerItineraryContinuationData4;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Passenger Itinerary Data 5: {}", e.getMessage());
            return passengerItineraryContinuationData4;
        }

        return passengerItineraryContinuationData4;
    }

    public PassengerItineraryData6 parsePassengerItineraryData6(String line) {
        PassengerItineraryData6 passengerItineraryContinuationData5 = new PassengerItineraryData6();

        try {
            passengerItineraryContinuationData5.setTransactionCode(line.substring(0, 2));
            passengerItineraryContinuationData5.setTransactionCodeQualifier(line.substring(2, 3));
            passengerItineraryContinuationData5.setTransactionComponentSequenceNumber(line.substring(3, 4));
            // Group Trip Leg 4 Information (Starts at position 5 - index 4)
            passengerItineraryContinuationData5.setCarrierCode(line.substring(4, 6)); // Position 5-6 (Length 2)
            passengerItineraryContinuationData5.setServiceClass(line.substring(6, 7)); // Position 7 (Length 1)
            passengerItineraryContinuationData5.setStopOverCode(line.substring(7, 8)); // Position 8 (Length 1)
            passengerItineraryContinuationData5.setDestinationCityAirport(line.substring(8, 11)); // Position 9-11 (Length 3)
            // Fields that follow
            passengerItineraryContinuationData5.setFareBasisCode_Leg4(line.substring(11, 17)); // Position 12-17 (Length 6)
            passengerItineraryContinuationData5.setFlightNumber_Leg4(line.substring(17, 22)); // Position 18-22 (Length 5)
            passengerItineraryContinuationData5.setDepartureDate_Leg4(line.substring(22, 28)); // Position 23-28 (Length 6)
            passengerItineraryContinuationData5.setDepartureTime_Leg4(line.substring(28, 32)); // Position 29-32 (Length 4)
            passengerItineraryContinuationData5.setDepartureTimeSegment_Leg4(line.substring(32, 33)); // Position 33 (Length 1)
            passengerItineraryContinuationData5.setArrivalTime_Leg4(line.substring(33, 37)); // Position 34-37 (Length 4)
            passengerItineraryContinuationData5.setArrivalTimeSegment_Leg4(line.substring(37, 38)); // Position 38 (Length 1)
            passengerItineraryContinuationData5.setEndorsementRestrictions_Leg4(line.substring(38, 58)); // Position 39-58 (Length 20)
            passengerItineraryContinuationData5.setConjunctionTicket_Leg4(line.substring(58, 83)); // Position 59-83 (Length 25)
            passengerItineraryContinuationData5.setExchangeTicket_Leg4(line.substring(83, 108)); // Position 84-108 (Length 25)
            passengerItineraryContinuationData5.setCouponNumber_Leg4(line.substring(108, 109)); // Position 109 (Length 1)
            passengerItineraryContinuationData5.setFareAmount_Leg4(line.substring(109, 121)); // Position 110-121 (Length 12)
            passengerItineraryContinuationData5.setTaxAmount_Leg4(line.substring(121, 133)); // Position 122-133 (Length 12)
            passengerItineraryContinuationData5.setFeeAmount_Leg4(line.substring(133, 145)); // Position 134-145 (Length 12)
            passengerItineraryContinuationData5.setReserved(line.substring(145, 168)); // Position 146-168 (Length 23)

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Passenger Itinerary Data 6: {}", e.getMessage());
            return passengerItineraryContinuationData5;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Passenger Itinerary Data 6: {}", e.getMessage());
            return passengerItineraryContinuationData5;
        }

        return passengerItineraryContinuationData5;
    }

    public PassengerTransport parsePassengerTransport(String line) {
        PassengerTransport passengerItineraryIndustryData = new PassengerTransport();

        try {
            passengerItineraryIndustryData.setTransactionCode(line.substring(0, 2));
            passengerItineraryIndustryData.setTransactionCodeQualifier(line.substring(2, 3));
            passengerItineraryIndustryData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            passengerItineraryIndustryData.setAncillaryTicketDocumentNumber(line.substring(4, 19));
            passengerItineraryIndustryData.setAncillaryCreditReasonIndicator(line.substring(19, 20));
            passengerItineraryIndustryData.setAncillaryServiceCategory1(line.substring(20, 24));
            passengerItineraryIndustryData.setAncillaryServiceSubCategory1(line.substring(24, 28));
            passengerItineraryIndustryData.setAncillaryServiceCategory2(line.substring(28, 32));
            passengerItineraryIndustryData.setAncillaryServiceSubCategory2(line.substring(32, 36));

            passengerItineraryIndustryData.setAncillaryServiceCategory3(line.substring(36, 40));
            passengerItineraryIndustryData.setAncillaryServiceSubCategory3(line.substring(40, 44));
            passengerItineraryIndustryData.setAncillaryServiceCategory4(line.substring(44, 48));
            passengerItineraryIndustryData.setAncillaryServiceSubCategory4(line.substring(48, 52));
            passengerItineraryIndustryData.setAncillaryPassengerName(line.substring(52, 72));
            passengerItineraryIndustryData.setIssuedInConnectionWithTicketNumber(line.substring(72, 87));
            passengerItineraryIndustryData.setReserved(line.substring(87, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Passenger Transport: {}", e.getMessage());
            return passengerItineraryIndustryData;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Passenger Transport: {}", e.getMessage());
            return passengerItineraryIndustryData;
        }

        return passengerItineraryIndustryData;
    }

    public PassengerItineraryData7 parsePassengerItineraryData7(String line) {
        PassengerItineraryData7 passengerItineraryContinuationData6 = new PassengerItineraryData7();

        try {
            passengerItineraryContinuationData6.setTransactionCode(line.substring(0, 2));
            passengerItineraryContinuationData6.setTransactionCodeQualifier(line.substring(2, 3));
            passengerItineraryContinuationData6.setTransactionComponentSequenceNumber(line.substring(3, 4));
            passengerItineraryContinuationData6.setIssuingCarrier(line.substring(4, 8));
            passengerItineraryContinuationData6.setTicketType(line.substring(8, 11));
            passengerItineraryContinuationData6.setDocumentType(line.substring(11, 13));
            passengerItineraryContinuationData6.setTicketingCarrierName(line.substring(13, 38));
            passengerItineraryContinuationData6.setTicketIssueCity(line.substring(38, 56));
            passengerItineraryContinuationData6.setTicketIssueDate(line.substring(56, 64));
            passengerItineraryContinuationData6.setNumberInParty(line.substring(64, 67));
            passengerItineraryContinuationData6.setElectronicTicketIndicator(line.substring(67, 68));
            passengerItineraryContinuationData6.setPlanNumber(line.substring(68, 70));
            passengerItineraryContinuationData6.setArrivalDateOverall(line.substring(70, 78));
            passengerItineraryContinuationData6.setRestrictionIndicatorText(line.substring(78, 98));
            passengerItineraryContinuationData6.setExchangeAmountSummary(line.substring(98, 110));
            passengerItineraryContinuationData6.setExchangeFeeSummary(line.substring(110, 122));
            passengerItineraryContinuationData6.setReserved(line.substring(122, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Passenger Itinerary Data 7: {}", e.getMessage());
            return passengerItineraryContinuationData6;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Passenger Itinerary Data 7: {}", e.getMessage());
            return passengerItineraryContinuationData6;
        }

        return passengerItineraryContinuationData6;
    }

    public EnhancedDataPurchasingTransactionLineItemDetail parseEnhancedDataPurchasingTransactionLineItemDetail(String line) {
        EnhancedDataPurchasingTransactionLineItemDetail enhancedDataLineItem = new EnhancedDataPurchasingTransactionLineItemDetail();

        try {
            enhancedDataLineItem.setTransactionCode(line.substring(0, 2));
            enhancedDataLineItem.setTransactionCodeQualifier(line.substring(2, 3));
            enhancedDataLineItem.setTransactionComponentSequenceNumber(line.substring(3, 4));
            enhancedDataLineItem.setDestinationIdentifier(line.substring(4, 10));
            enhancedDataLineItem.setSourceIdentifier(line.substring(10, 16));
            enhancedDataLineItem.setTc33ApplicationCode(line.substring(16, 20));
            enhancedDataLineItem.setMessageIdentifier(line.substring(20, 35));
            enhancedDataLineItem.setItemSequenceNumber(line.substring(35, 38));
            enhancedDataLineItem.setItemCommodityCode(line.substring(38, 50));
            enhancedDataLineItem.setItemDescriptor(line.substring(50, 85));
            enhancedDataLineItem.setProductCode(line.substring(85, 100));
            enhancedDataLineItem.setQuantity(line.substring(100, 112));
            enhancedDataLineItem.setUnitOfMeasureCode(line.substring(112, 124));
            enhancedDataLineItem.setUnitCost(line.substring(124, 136));
            enhancedDataLineItem.setLineItemTotal(line.substring(136, 148));
            enhancedDataLineItem.setDiscountPerLine(line.substring(148, 160));
            enhancedDataLineItem.setTaxExemptIndicator(line.substring(160, 161));
            enhancedDataLineItem.setItemDiscountDiscountRate(line.substring(161, 166));
            enhancedDataLineItem.setItemLevelDiscountTreatmentCode(line.substring(166, 167));
            enhancedDataLineItem.setLineItemSignage(line.substring(167, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Enhanced Data Purchasing Transaction Line Item Detail: {}", e.getMessage());
            return enhancedDataLineItem;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Enhanced Data Purchasing Transaction Line Item Detail: {}", e.getMessage());
            return enhancedDataLineItem;
        }

        return enhancedDataLineItem;
    }

    public PurchasingTransactionLineItemDetail parsePurchasingTransactionLineItemDetail(String line) {
        PurchasingTransactionLineItemDetail enhancedDataLineItemContinuation = new PurchasingTransactionLineItemDetail();

        try {
            enhancedDataLineItemContinuation.setTransactionCode(line.substring(0, 2));
            enhancedDataLineItemContinuation.setTransactionCodeQualifier(line.substring(2, 3));
            enhancedDataLineItemContinuation.setTransactionComponentSequenceNumber(line.substring(3, 4));
            enhancedDataLineItemContinuation.setVatTaxAmount(line.substring(4, 16));

            enhancedDataLineItemContinuation.setVatTaxRate(line.substring(16, 20));
            enhancedDataLineItemContinuation.setTypeOfSupply(line.substring(20, 22));
            enhancedDataLineItemContinuation.setUniqueVatInvoiceReferenceNumber(line.substring(22, 37));
            enhancedDataLineItemContinuation.setReserved(line.substring(37, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Purchasing Transaction Line Item Detail: {}", e.getMessage());
            return enhancedDataLineItemContinuation;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Purchasing Transaction Line Item Detail: {}", e.getMessage());
            return enhancedDataLineItemContinuation;
        }

        return enhancedDataLineItemContinuation;
    }

    public CountryData parseCountryData(String line) {
        CountryData countryData = new CountryData();

        try {
            countryData.setTransactionCode(line.substring(0, 2));
            countryData.setTransactionCodeQualifier(line.substring(2, 3));
            countryData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            countryData.setDestinationIdentifier(line.substring(4, 10));
            countryData.setSourceIdentifier(line.substring(10, 16));
            countryData.setTc33ApplicationCode(line.substring(16, 20));
            countryData.setMessageIdentifier(line.substring(20, 35));
            countryData.setSpecialMerchantIdentifier(line.substring(35, 40));
            countryData.setSpecialPurchaseIdentifier(line.substring(40, 41));
            countryData.setAccountSelection(line.substring(41, 43));
            countryData.setAccountAccessed(line.substring(43, 47));
            countryData.setMastercardBillPaymentTransactionTypeIdentifier(line.substring(47, 50));
            countryData.setMastercardCombinationCardTransactionIdentifier(line.substring(50, 51));
            countryData.setMastercardPostDatedTransactionDetails(line.substring(51, 90));
            countryData.setMastercardPromotionCode(line.substring(90, 96));
            countryData.setReserved(line.substring(96, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Country Data: {}", e.getMessage());
            return countryData;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Country Data: {}", e.getMessage());
            return countryData;
        }

        return countryData;
    }

    public BrazilCountryDataPARC parseBrazilCountryDataPARC(String line) {
        BrazilCountryDataPARC brazilCountryData = new BrazilCountryDataPARC();

        try {
            brazilCountryData.setTransactionCode(line.substring(0, 2));
            brazilCountryData.setTransactionCodeQualifier(line.substring(2, 3));
            brazilCountryData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            brazilCountryData.setInstallmentType(line.substring(4, 6));
            brazilCountryData.setNumberOfInstallments(line.substring(6, 8));
            brazilCountryData.setMerchantInstallmentSupportingInformation(line.substring(8, 9));
            brazilCountryData.setReserved(line.substring(9, 168));

        } catch (Exception e) {
            log.warn("Exception caught while parsing Brazil Country Data PARC: {}", e.getMessage());
            return brazilCountryData;
        }

        return brazilCountryData;
    }

    public BrazilCountryDataBNDES parseBrazilCountryDataBNDES(String line) {
        BrazilCountryDataBNDES brazilCountryDataBNDES = new BrazilCountryDataBNDES();

        try {
            brazilCountryDataBNDES.setTransactionCode(line.substring(0, 2));
            brazilCountryDataBNDES.setTransactionCodeQualifier(line.substring(2, 3));

            brazilCountryDataBNDES.setTransactionComponentSequenceNumber(line.substring(3, 4));
            brazilCountryDataBNDES.setBusinessFormatCode(line.substring(4, 6));
            brazilCountryDataBNDES.setCardholderTaxID(line.substring(6, 21));
            brazilCountryDataBNDES.setCardholderTaxIDType(line.substring(21, 25));
            brazilCountryDataBNDES.setAssetIndicator(line.substring(25, 26));
            brazilCountryDataBNDES.setLoanType(line.substring(26, 46));
            brazilCountryDataBNDES.setReserved(line.substring(46, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Brazil Country Data BNDES: {}", e.getMessage());
            return brazilCountryDataBNDES;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Brazil Country Data BNDES: {}", e.getMessage());
            return brazilCountryDataBNDES;
        }

        return brazilCountryDataBNDES;
    }

    public BrazilCountryDataAmericanExpress parseBrazilCountryDataAmericanExpress(String line) {
        BrazilCountryDataAmericanExpress brazilCountryDataAmexInstallment = new BrazilCountryDataAmericanExpress();

        try {
            brazilCountryDataAmexInstallment.setTransactionCode(line.substring(0, 2));
            brazilCountryDataAmexInstallment.setTransactionCodeQualifier(line.substring(2, 3));
            brazilCountryDataAmexInstallment.setTransactionComponentSequenceNumber(line.substring(3, 4));
            brazilCountryDataAmexInstallment.setPlanType(line.substring(4, 6));
            brazilCountryDataAmexInstallment.setNumberOfInstallments(line.substring(6, 8));

            brazilCountryDataAmexInstallment.setReserved(line.substring(8, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Brazil Country Data American Express: {}", e.getMessage());
            return brazilCountryDataAmexInstallment;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Brazil Country Data American Express: {}", e.getMessage());
            return brazilCountryDataAmexInstallment;
        }

        return brazilCountryDataAmexInstallment;
    }

    public CommercialMastercardInstallmentPayments parseCommercialMastercardInstallmentPayments(String line) {
        CommercialMastercardInstallmentPayments installmentRecord = new CommercialMastercardInstallmentPayments();

        try {
            installmentRecord.setTransactionCode(line.substring(0, 2));
            installmentRecord.setTransactionCodeQualifier(line.substring(2, 3));
            installmentRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            installmentRecord.setFinancingType(line.substring(4, 24));
            installmentRecord.setBuyerTypeID(line.substring(24, 25));
            installmentRecord.setBuyerID(line.substring(25, 39));
            installmentRecord.setBuyerPhoneNumber(line.substring(39, 50));
            installmentRecord.setPurchaseIdentification(line.substring(50, 70));
            installmentRecord.setInstallmentCycles(line.substring(70, 72));
            installmentRecord.setInterestRate(line.substring(72, 90));
            installmentRecord.setGracePeriod(line.substring(90, 93));
            installmentRecord.setGracePeriodCycle(line.substring(93, 96));
            installmentRecord.setGracePeriodInterestRate(line.substring(96, 114));
            installmentRecord.setReferenceField1(line.substring(114, 134));
            installmentRecord.setReferenceField2(line.substring(134, 154));
            installmentRecord.setReserved(line.substring(154, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Commercial Mastercard Installment Payments: {}", e.getMessage());
            return installmentRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Commercial Mastercard Installment Payments: {}", e.getMessage());
            return installmentRecord;
        }

        return installmentRecord;
    }

    public ConsumerMastercardInstallmentPayments parseConsumerMastercardInstallmentPayments(String line) {
        ConsumerMastercardInstallmentPayments installmentRecord = new ConsumerMastercardInstallmentPayments();

        try {
            installmentRecord.setTransactionCode(line.substring(0, 2));
            installmentRecord.setTransactionCodeQualifier(line.substring(2, 3));
            installmentRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            installmentRecord.setInsuranceAmount(line.substring(4, 11));
            installmentRecord.setPercentInsuranceOfTotalAmount(line.substring(11, 15));
            installmentRecord.setPercentAmountToMerchantOfTotalAmount(line.substring(15, 20));
            installmentRecord.setMonthlyInterestRate(line.substring(20, 24));
            installmentRecord.setFeeAmount(line.substring(24, 31));
            installmentRecord.setTotalAmountToMerchant(line.substring(31, 38));
            installmentRecord.setTaxAmount(line.substring(38, 45));
            installmentRecord.setPercentFeeOfTotalAmount(line.substring(45, 49));
            installmentRecord.setPercentTaxesOfTotalAmount(line.substring(49, 53));
            installmentRecord.setOtherAmount(line.substring(53, 60));
            installmentRecord.setPercentOtherOfTotalAmount(line.substring(60, 64));
            installmentRecord.setPercentTotalEffectiveCost(line.substring(64, 71));
            installmentRecord.setTotalEffectiveCost(line.substring(71, 83));
            installmentRecord.setReserved(line.substring(83, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Consumer Mastercard Installment Payments: {}", e.getMessage());
            return installmentRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Consumer Mastercard Installment Payments: {}", e.getMessage());
            return installmentRecord;
        }

        return installmentRecord;
    }

    public BrazilCountryDataMastercardBNDES1 parseBrazilCountryDataMastercardBNDES1(String line) {
        BrazilCountryDataMastercardBNDES1 bndes1Record = new BrazilCountryDataMastercardBNDES1();

        try {
            bndes1Record.setTransactionCode(line.substring(0, 2));
            bndes1Record.setTransactionCodeQualifier(line.substring(2, 3));
            bndes1Record.setTransactionComponentSequenceNumber(line.substring(3, 4));
            bndes1Record.setFinancingType(line.substring(4, 24));
            bndes1Record.setBuyerIDType(line.substring(24, 25));
            bndes1Record.setBuyerID(line.substring(25, 39));
            bndes1Record.setBndesReferenceField1(line.substring(39, 59));
            bndes1Record.setReserved(line.substring(59, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Brazil Country Data Mastercard BNDES1: {}", e.getMessage());
            return bndes1Record;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Brazil Country Data Mastercard BNDES1: {}", e.getMessage());
            return bndes1Record;
        }

        return bndes1Record;
    }

    public DebtRepaymentInformation parseDebtRepaymentInformation(String line) {
        DebtRepaymentInformation debtRepaymentRecord = new DebtRepaymentInformation();

        try {
            debtRepaymentRecord.setTransactionCode(line.substring(0, 2));
            debtRepaymentRecord.setTransactionCodeQualifier(line.substring(2, 3));
            debtRepaymentRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            debtRepaymentRecord.setDebtRepaymentRecipientLastName(line.substring(4, 39));
            debtRepaymentRecord.setDebtRepaymentRecipientPostalCode(line.substring(39, 49));
            debtRepaymentRecord.setDebtRepaymentRecipientDateOfBirth(line.substring(49, 57));
            debtRepaymentRecord.setDebtRepaymentRecipientAccountNumber(line.substring(57, 77));
            debtRepaymentRecord.setReserved(line.substring(77, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Debt Repayment Information: {}", e.getMessage());
            return debtRepaymentRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Debt Repayment Information: {}", e.getMessage());
            return debtRepaymentRecord;
        }

        return debtRepaymentRecord;
    }

    public JapanMCAdditionalData parseJapanMCAdditionalData(String line) {
        JapanMCAdditionalData japanMCAdditionalData = new JapanMCAdditionalData();

        try {
            japanMCAdditionalData.setTransactionCode(line.substring(0, 2));
            japanMCAdditionalData.setTransactionCodeQualifier(line.substring(2, 3));
            japanMCAdditionalData.setTransactionComponentSequenceNumber(line.substring(3, 4));
            japanMCAdditionalData.setJapanDomesticPOSData(line.substring(4, 94));
            japanMCAdditionalData.setAcquirerCompanyCode(line.substring(94, 101));
            japanMCAdditionalData.setIssuerCompanyCode(line.substring(101, 108));
            japanMCAdditionalData.setAuthorizationTransmissionMode(line.substring(108, 109));
            japanMCAdditionalData.setEntryIndicator(line.substring(109, 110));
            japanMCAdditionalData.setApprovalNumberForPostApprovalAuthorizations(line.substring(110, 116));
            japanMCAdditionalData.setTaxAmount(line.substring(116, 123));
            japanMCAdditionalData.setLocalTransactionDate(line.substring(123, 128));
            japanMCAdditionalData.setReserved(line.substring(128, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Japan MC Additional Data: {}", e.getMessage());
            return japanMCAdditionalData;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Japan MC Additional Data: {}", e.getMessage());
            return japanMCAdditionalData;
        }

        return japanMCAdditionalData;
    }

    public EUSpecificProcessing parseEUSpecificProcessing(String line) {
        EUSpecificProcessing euSpecificProcessingRecord = new EUSpecificProcessing();

        try {
            euSpecificProcessingRecord.setTransactionCode(line.substring(0, 2));
            euSpecificProcessingRecord.setTransactionCodeQualifier(line.substring(2, 3));
            euSpecificProcessingRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            euSpecificProcessingRecord.setDelegatedAuthenticationIndicator(line.substring(4, 5));
            euSpecificProcessingRecord.setLowValueExemptionIndicator(line.substring(5, 6));
            euSpecificProcessingRecord.setTransactionRiskAnalysisExemptionIndicator(line.substring(6, 7));
            euSpecificProcessingRecord.setTrustedMerchantExemptionIndicator(line.substring(7, 8));
            euSpecificProcessingRecord.setSecureCorporatePaymentIndicator(line.substring(8, 9));
            euSpecificProcessingRecord.setSpainLocalMCC(line.substring(9, 13));
            euSpecificProcessingRecord.setSpainLocalMerchantID(line.substring(13, 28));
            euSpecificProcessingRecord.setSessionID(line.substring(28, 60));
            euSpecificProcessingRecord.setReasonsForNotHonoringSCAExemptions(line.substring(60, 140));
            euSpecificProcessingRecord.setReserved(line.substring(140, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing EU Specific Processing: {}", e.getMessage());
            return euSpecificProcessingRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing EU Specific Processing: {}", e.getMessage());
            return euSpecificProcessingRecord;
        }

        return euSpecificProcessingRecord;
    }

    public PolandMCSpecificCommercialCards parsePolandMCSpecificCommercialCards(String line) {
        PolandMCSpecificCommercialCards polandRecord = new PolandMCSpecificCommercialCards();

        try {
            polandRecord.setTransactionCode(line.substring(0, 2));
            polandRecord.setTransactionCodeQualifier(line.substring(2, 3));
            polandRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            polandRecord.setVatAmount(line.substring(4, 16));
            polandRecord.setNetAmount(line.substring(16, 28));
            polandRecord.setMerchantTaxID(line.substring(28, 48));
            polandRecord.setInvoiceNumber(line.substring(48, 88));
            polandRecord.setReserved(line.substring(88, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Poland MC Specific Commercial Cards: {}", e.getMessage());
            return polandRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Poland MC Specific Commercial Cards: {}", e.getMessage());
            return polandRecord;
        }

        return polandRecord;
    }

    public ColombiaMastercardDomesticProcessing parseColombiaMastercardDomesticProcessing(String line) {
        ColombiaMastercardDomesticProcessing colombiaRecord = new ColombiaMastercardDomesticProcessing();

        try {
            colombiaRecord.setTransactionCode(line.substring(0, 2));
            colombiaRecord.setTransactionCodeQualifier(line.substring(2, 3));
            colombiaRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));

            colombiaRecord.setMastercardPurchaseTaxIVA(line.substring(4, 16));
            colombiaRecord.setMastercardPurchaseTaxAmountBase(line.substring(16, 28));
            colombiaRecord.setMastercardPurchaseRetailerData(line.substring(28, 55));
            colombiaRecord.setMastercardPurchaseTerminalAcquirerData(line.substring(55, 71));
            colombiaRecord.setMastercardPurchaseBillPaymentTopUpData(line.substring(71, 107));
            colombiaRecord.setMastercardPurchaseLocalPOSData(line.substring(107, 108));
            colombiaRecord.setMastercardPurchaseLocalResponseCodes(line.substring(108, 110));
            colombiaRecord.setMastercardPurchaseOriginalTransactionData(line.substring(110, 152));
            colombiaRecord.setMastercardPurchaseIACTaxAmount(line.substring(152, 164));
            colombiaRecord.setReserved(line.substring(164, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Colombia Mastercard Domestic Processing: {}", e.getMessage());
            return colombiaRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Colombia Mastercard Domestic Processing: {}", e.getMessage());
            return colombiaRecord;
        }

        return colombiaRecord;
    }

    public DiscretionaryDataDefault parseDiscretionaryDataDefault(String line) {
        DiscretionaryDataDefault defaultTCRRecord = new DiscretionaryDataDefault();

        try {
            defaultTCRRecord.setTransactionCode(line.substring(0, 2));
            defaultTCRRecord.setTransactionCodeQualifier(line.substring(2, 3));
            defaultTCRRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            defaultTCRRecord.setDestinationIdentifier(line.substring(4, 10));
            defaultTCRRecord.setSourceIdentifier(line.substring(10, 16));
            defaultTCRRecord.setTc33ApplicationCode(line.substring(16, 20));
            defaultTCRRecord.setMessageIdentifier(line.substring(20, 35));
            defaultTCRRecord.setReserved(line.substring(35, 168));

        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error parsing data: Input line is too short. " + e.getMessage());
            return null;
        }

        return defaultTCRRecord;
    }

    public FreeFormText parseFreeFormText(String line) {
        FreeFormText freeFormTextRecord = new FreeFormText();

        try {
            freeFormTextRecord.setTransactionCode(line.substring(0, 2));
            freeFormTextRecord.setTransactionCodeQualifier(line.substring(2, 3));
            freeFormTextRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            freeFormTextRecord.setFreeFormText(line.substring(4, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Free Form Text: {}", e.getMessage());
            return freeFormTextRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Free Form Text: {}", e.getMessage());
            return freeFormTextRecord;
        }

        return freeFormTextRecord;
    }

    public PushPayment parsePushPayment(String line) {
        PushPayment pushPaymentRecord = new PushPayment();

        try {
            pushPaymentRecord.setTransactionCode(line.substring(0, 2));
            pushPaymentRecord.setTransactionCodeQualifier(line.substring(2, 3));
            pushPaymentRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            pushPaymentRecord.setDestinationIdentifier(line.substring(4, 10));
            pushPaymentRecord.setSourceIdentifier(line.substring(10, 16));
            pushPaymentRecord.setTc33ApplicationCode(line.substring(16, 20));
            pushPaymentRecord.setMessageIdentifier(line.substring(20, 35));
            pushPaymentRecord.setAftForeignExchangeFee(line.substring(35, 47));
            pushPaymentRecord.setOctAccountType(line.substring(47, 49));
            pushPaymentRecord.setOctAmountType(line.substring(49, 51));
            pushPaymentRecord.setOctAmountSign(line.substring(51, 52));
            pushPaymentRecord.setPurposeOfPaymentCode(line.substring(52, 64));
            pushPaymentRecord.setOctAcceptorLegalBusinessName(line.substring(64, 89));
            pushPaymentRecord.setOctPaymentFacilitatorName(line.substring(89, 114));
            pushPaymentRecord.setReserved(line.substring(114, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Push Payment: {}", e.getMessage());
            return pushPaymentRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Push Payment: {}", e.getMessage());
            return pushPaymentRecord;
        }

        return pushPaymentRecord;
    }

    public PushPaymentOriginalCreditTransaction parsePushPaymentOriginalCreditTransaction(String line) {
        PushPaymentOriginalCreditTransaction pushPaymentOCTRecord = new PushPaymentOriginalCreditTransaction();

        try {
            pushPaymentOCTRecord.setTransactionCode(line.substring(0, 2));
            pushPaymentOCTRecord.setTransactionCodeQualifier(line.substring(2, 3));
            pushPaymentOCTRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            pushPaymentOCTRecord.setBusinessFormatCode(line.substring(4, 6));
            pushPaymentOCTRecord.setMoneyTransferRecipientName(line.substring(6, 36));
            pushPaymentOCTRecord.setSourceOfFunds(line.substring(36, 38));
            pushPaymentOCTRecord.setClaimsCode(line.substring(38, 58));
            pushPaymentOCTRecord.setTaxDocumentType(line.substring(58, 78));
            pushPaymentOCTRecord.setCustomerReferenceNumber(line.substring(78, 80));
            pushPaymentOCTRecord.setIdentificationTypeCode(line.substring(80, 84));
            pushPaymentOCTRecord.setIdentificationSubtype(line.substring(84, 86));
            pushPaymentOCTRecord.setIdentificationValue(line.substring(86, 121));
            pushPaymentOCTRecord.setIdentificationIssuingCountry(line.substring(121, 124));
            pushPaymentOCTRecord.setContactInformationAccountReferenceNumber(line.substring(124, 126));
            pushPaymentOCTRecord.setContactInformationEntityType(line.substring(126, 128));
            pushPaymentOCTRecord.setReserved(line.substring(128, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Push Payment Original Credit Transaction: {}", e.getMessage());
            return pushPaymentOCTRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Push Payment Original Credit Transaction: {}", e.getMessage());
            return pushPaymentOCTRecord;
        }

        return pushPaymentOCTRecord;
    }

    public OriginalCreditTransactionAndAccountFundingTransaction parseOriginalCreditTransactionAndAccountFundingTransaction(String line) {
        OriginalCreditTransactionAndAccountFundingTransaction detailsRecord = new OriginalCreditTransactionAndAccountFundingTransaction();

        try {
            detailsRecord.setTransactionCode(line.substring(0, 2));
            detailsRecord.setTransactionCodeQualifier(line.substring(2, 3));
            detailsRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            detailsRecord.setSenderReferenceNumber(line.substring(4, 20));
            detailsRecord.setSenderAccountNumber(line.substring(20, 54));
            detailsRecord.setSenderName(line.substring(54, 84));
            detailsRecord.setSenderAddress(line.substring(84, 119));
            detailsRecord.setSenderCity(line.substring(119, 144));
            detailsRecord.setSenderStateProvince(line.substring(144, 146));
            detailsRecord.setSenderCountry(line.substring(146, 149));
            detailsRecord.setReserved(line.substring(149, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Original Credit Transaction And Account Funding Transaction: {}", e.getMessage());
            return detailsRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Original Credit Transaction And Account Funding Transaction: {}", e.getMessage());
            return detailsRecord;
        }

        return detailsRecord;
    }

    public SenderName parseSenderName(String line) {
        SenderName senderNameSplitRecord = new SenderName();

        try {
            senderNameSplitRecord.setTransactionCode(line.substring(0, 2));
            senderNameSplitRecord.setTransactionCodeQualifier(line.substring(2, 3));
            senderNameSplitRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            senderNameSplitRecord.setAccountOwnerNameGiven(line.substring(4, 39));
            senderNameSplitRecord.setAccountOwnerMiddleName(line.substring(39, 74));
            senderNameSplitRecord.setAccountOwnerLastName(line.substring(74, 109));
            senderNameSplitRecord.setSenderEntityType(line.substring(109, 111));
            senderNameSplitRecord.setReserved(line.substring(111, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Sender Name: {}", e.getMessage());
            return senderNameSplitRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Sender Name: {}", e.getMessage());
            return senderNameSplitRecord;
        }

        return senderNameSplitRecord;
    }

    public RecipientName parseRecipientName(String line) {
        RecipientName recipientNameSplitRecord = new RecipientName();

        try {
            recipientNameSplitRecord.setTransactionCode(line.substring(0, 2));
            recipientNameSplitRecord.setTransactionCodeQualifier(line.substring(2, 3));
            recipientNameSplitRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            recipientNameSplitRecord.setAccountOwnerNameGiven(line.substring(4, 39));
            recipientNameSplitRecord.setAccountOwnerMiddleName(line.substring(39, 74));
            recipientNameSplitRecord.setAccountOwnerLastName(line.substring(74, 109));
            recipientNameSplitRecord.setReserved(line.substring(109, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Recipient Name: {}", e.getMessage());
            return recipientNameSplitRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Recipient Name: {}", e.getMessage());
            return recipientNameSplitRecord;
        }

        return recipientNameSplitRecord;
    }

    public RecipientAdditionalData parseRecipientAdditionalData(String line) {
        RecipientAdditionalData recipientRecord = new RecipientAdditionalData();

        try {
            recipientRecord.setTransactionCode(line.substring(0, 2));
            recipientRecord.setTransactionCodeQualifier(line.substring(2, 3));
            recipientRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            recipientRecord.setAccountOwnerAddressLine1(line.substring(4, 103));
            recipientRecord.setAccountOwnerSenderCity(line.substring(103, 128));
            recipientRecord.setAccountOwnerSubdivisionCodeMajor(line.substring(128, 131));

            recipientRecord.setAccountOwnerSenderCountry(line.substring(131, 134));
            recipientRecord.setReserved(line.substring(134, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Recipient Additional Data: {}", e.getMessage());
            return recipientRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Recipient Additional Data: {}", e.getMessage());
            return recipientRecord;
        }

        return recipientRecord;
    }

    public AccountFundingTransactionDetails parseAccountFundingTransactionDetails(String line) {
        AccountFundingTransactionDetails aftDetailsRecord = new AccountFundingTransactionDetails();

        try {
            aftDetailsRecord.setTransactionCode(line.substring(0, 2));
            aftDetailsRecord.setTransactionCodeQualifier(line.substring(2, 3));
            aftDetailsRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            aftDetailsRecord.setAccountIdentifierReference(line.substring(4, 6));
            aftDetailsRecord.setAccountIdentifierValue(line.substring(6, 40));
            aftDetailsRecord.setAccountIdentifierTypeCode(line.substring(40, 42));
            aftDetailsRecord.setNationalReimbursementFee(line.substring(42, 54));
            aftDetailsRecord.setReserved(line.substring(54, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Account Funding Transaction Details: {}", e.getMessage());
            return aftDetailsRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Account Funding Transaction Details: {}", e.getMessage());
            return aftDetailsRecord;
        }

        return aftDetailsRecord;
    }

    public CarRentalDefault parseCarRentalDefault(String line) {
        CarRentalDefault carRentalRecord = new CarRentalDefault();

        try {
            carRentalRecord.setTransactionCode(line.substring(0, 2));
            carRentalRecord.setTransactionCodeQualifier(line.substring(2, 3));
            carRentalRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            carRentalRecord.setDestinationIdentifier(line.substring(4, 10));
            carRentalRecord.setSourceIdentifier(line.substring(10, 16));
            carRentalRecord.setTc33ApplicationCode(line.substring(16, 20));
            carRentalRecord.setMessageIdentifier(line.substring(20, 35));
            carRentalRecord.setRenterName(line.substring(35, 75));
            carRentalRecord.setCarRentalCheckOutDate(line.substring(75, 83));
            carRentalRecord.setInsuranceCharges(line.substring(83, 95));
            carRentalRecord.setCarClassCode(line.substring(95, 99));
            carRentalRecord.setOneWayDropOffCharges(line.substring(99, 111));
            carRentalRecord.setCarRentalNoShowIndicator(line.substring(111, 112));
            carRentalRecord.setDaysRented(line.substring(112, 114));
            carRentalRecord.setAdjustmentAmountIndicatorCode(line.substring(114, 115));
            carRentalRecord.setAdjustedAmount(line.substring(115, 127));
            carRentalRecord.setFuelCharges(line.substring(127, 139));
            carRentalRecord.setTimePeriod(line.substring(139, 140));
            carRentalRecord.setWeeklyRentalRate(line.substring(140, 152));
            carRentalRecord.setMilesKilometerIndicator(line.substring(152, 153));
            carRentalRecord.setReserved(line.substring(153, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Car Rental Default: {}", e.getMessage());
            return carRentalRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Car Rental Default: {}", e.getMessage());
            return carRentalRecord;
        }

        return carRentalRecord;
    }

    public CarRentalDefault2 parseCarRentalDefault2(String line) {
        CarRentalDefault2 carRentalContdRecord = new CarRentalDefault2();

        try {
            carRentalContdRecord.setTransactionCode(line.substring(0, 2));
            carRentalContdRecord.setTransactionCodeQualifier(line.substring(2, 3));
            carRentalContdRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));

            carRentalContdRecord.setRentalReturnStateProvince(line.substring(4, 7));
            carRentalContdRecord.setRentalReturnCountry(line.substring(7, 10));
            carRentalContdRecord.setRentalReturnDate(line.substring(10, 18));
            carRentalContdRecord.setRentalAgreement(line.substring(18, 43));
            carRentalContdRecord.setRenterReturnCity(line.substring(43, 68));
            carRentalContdRecord.setRentalLocationCity(line.substring(68, 93));
            carRentalContdRecord.setRentalLocationStateProvince(line.substring(93, 96));
            carRentalContdRecord.setRentalLocationCountry(line.substring(96, 99));
            carRentalContdRecord.setTotalMilesOrKilometers(line.substring(99, 104));
            carRentalContdRecord.setRentalLocationID(line.substring(104, 114));
            carRentalContdRecord.setRentalReturnLocationID(line.substring(114, 124));
            carRentalContdRecord.setReturnDropOffLocation(line.substring(124, 162));
            carRentalContdRecord.setReserved(line.substring(162, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Car Rental Default 2: {}", e.getMessage());
            return carRentalContdRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Car Rental Default 2: {}", e.getMessage());
            return carRentalContdRecord;
        }

        return carRentalContdRecord;
    }

    public CarRentalDefault3 parseCarRentalDefault3(String line) {
        CarRentalDefault3 carRentalContd2Record = new CarRentalDefault3();

        try {
            carRentalContd2Record.setTransactionCode(line.substring(0, 2));
            carRentalContd2Record.setTransactionCodeQualifier(line.substring(2, 3));
            carRentalContd2Record.setTransactionComponentSequenceNumber(line.substring(3, 4));
            carRentalContd2Record.setTotalTaxAmount(line.substring(4, 16));
            carRentalContd2Record.setTaxAmountSign(line.substring(16, 17));
            carRentalContd2Record.setOdometer(line.substring(17, 25));
            carRentalContd2Record.setVehicleIdentificationNumber(line.substring(25, 45));
            carRentalContd2Record.setCommodityCode(line.substring(45, 60));
            carRentalContd2Record.setTaxExemptIndicator(line.substring(60, 61));
            carRentalContd2Record.setCorporateIdentifier(line.substring(61, 73));
            carRentalContd2Record.setRegularMileageCharge(line.substring(73, 85));
            carRentalContd2Record.setExtraMileageCharge(line.substring(85, 97));
            carRentalContd2Record.setLateCharge(line.substring(97, 109));
            carRentalContd2Record.setTotalTaxCollectedIndicator(line.substring(109, 110));
            carRentalContd2Record.setRatePerMileOrPerKilometer(line.substring(110, 122));
            carRentalContd2Record.setMaximumFreeMilesOrKilometers(line.substring(122, 126));
            carRentalContd2Record.setVehicleInsuranceIndicator(line.substring(126, 127));
            carRentalContd2Record.setProgramCode(line.substring(127, 129));
            carRentalContd2Record.setOtherCharges(line.substring(129, 141));
            carRentalContd2Record.setAutoRentalPickUpTime(line.substring(141, 147));
            carRentalContd2Record.setAutoRentalReturnTime(line.substring(147, 153));
            carRentalContd2Record.setDailyRentalRate(line.substring(153, 165));
            carRentalContd2Record.setReserved(line.substring(165, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Car Rental Default 3: {}", e.getMessage());
            return carRentalContd2Record;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Car Rental Default 3: {}", e.getMessage());
            return carRentalContd2Record;
        }

        return carRentalContd2Record;
    }

    public CarRentalDefault4 parseCarRentalDefault4(String line) {
        CarRentalDefault4 carRentalContd3Record = new CarRentalDefault4();

        try {
            carRentalContd3Record.setTransactionCode(line.substring(0, 2));
            carRentalContd3Record.setTransactionCodeQualifier(line.substring(2, 3));
            carRentalContd3Record.setTransactionComponentSequenceNumber(line.substring(3, 4));
            carRentalContd3Record.setTowingCharges(line.substring(4, 16));
            carRentalContd3Record.setExtraCharges(line.substring(16, 28));
            carRentalContd3Record.setParkingViolationCharges(line.substring(28, 40));
            carRentalContd3Record.setAdditionalDrivers(line.substring(40, 41));
            carRentalContd3Record.setRentalAddress(line.substring(41, 67));
            carRentalContd3Record.setAge(line.substring(67, 70));
            carRentalContd3Record.setSpecialProgramCode(line.substring(70, 72));
            carRentalContd3Record.setVehicleMake(line.substring(72, 82));
            carRentalContd3Record.setVehicleModel(line.substring(82, 92));
            carRentalContd3Record.setTravelAgencyCode(line.substring(92, 100));
            carRentalContd3Record.setTravelAgencyName(line.substring(100, 125));
            carRentalContd3Record.setTaxType(line.substring(125, 135));
            carRentalContd3Record.setTaxRate(line.substring(135, 137));
            carRentalContd3Record.setTaxElements(line.substring(137, 149));
            carRentalContd3Record.setReserved(line.substring(149, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Car Rental Default 4: {}", e.getMessage());
            return carRentalContd3Record;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Car Rental Default 4: {}", e.getMessage());
            return carRentalContd3Record;
        }

        return carRentalContd3Record;
    }

    public CarRentalDefault5 parseCarRentalDefault5(String line) {
        CarRentalDefault5 carRentalContd4Record = new CarRentalDefault5();

        try {
            carRentalContd4Record.setTransactionCode(line.substring(0, 2));
            carRentalContd4Record.setTransactionCodeQualifier(line.substring(2, 3));
            carRentalContd4Record.setTransactionComponentSequenceNumber(line.substring(3, 4));
            carRentalContd4Record.setCoupon(line.substring(4, 16));
            carRentalContd4Record.setAdditionalCoupon(line.substring(16, 28));
            carRentalContd4Record.setTotalAmount(line.substring(28, 40));
            carRentalContd4Record.setPhoneCharge(line.substring(40, 52));
            carRentalContd4Record.setGpsCharge(line.substring(52, 64));
            carRentalContd4Record.setPickupLocation(line.substring(64, 102));
            carRentalContd4Record.setDriverIdentificationNumber(line.substring(102, 122));
            carRentalContd4Record.setDriverTaxNumber(line.substring(122, 142));
            carRentalContd4Record.setCorporateClientCode(line.substring(142, 150));
            carRentalContd4Record.setCustomerServiceTollFree800Number(line.substring(150, 167));
            carRentalContd4Record.setReserved(line.substring(167, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Car Rental Default 5: {}", e.getMessage());
            return carRentalContd4Record;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Car Rental Default 5: {}", e.getMessage());
            return carRentalContd4Record;
        }

        return carRentalContd4Record;
    }

    public TransactionData2 parseTransactionData2(String line) {
        TransactionData2 transactionDataRecord = new TransactionData2();

        try {
            transactionDataRecord.setTransactionCode(line.substring(0, 2));
            transactionDataRecord.setTransactionCodeQualifier(line.substring(2, 3));
            transactionDataRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            transactionDataRecord.setDestinationIdentifier(line.substring(4, 10));
            transactionDataRecord.setSourceIdentifier(line.substring(10, 16));
            transactionDataRecord.setTc33ApplicationCode(line.substring(16, 20));
            transactionDataRecord.setMessageIdentifier(line.substring(20, 35));
            transactionDataRecord.setPersistentFXExchangeProvider(line.substring(35, 105));
            transactionDataRecord.setPersistentFXExchangeRate(line.substring(105, 113));
            transactionDataRecord.setTransactionLocalDateAndTime(line.substring(113, 123));
            transactionDataRecord.setReserved(line.substring(123, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Transaction Data 2: {}", e.getMessage());
            return transactionDataRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Transaction Data 2: {}", e.getMessage());
            return transactionDataRecord;
        }

        return transactionDataRecord;
    }

    public MerchantData2 parseMerchantData2(String line) {
        MerchantData2 merchantDataRecord = new MerchantData2();

        try {
            merchantDataRecord.setTransactionCode(line.substring(0, 2));
            merchantDataRecord.setTransactionCodeQualifier(line.substring(2, 3));
            merchantDataRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            merchantDataRecord.setVisaMerchantID(line.substring(4, 12));
            merchantDataRecord.setSystemTraceAuditName(line.substring(12, 18));
            merchantDataRecord.setExchangeRateTableID(line.substring(18, 23));
            merchantDataRecord.setPersistentFXEligibleIndicator(line.substring(23, 24));
            merchantDataRecord.setPersistentFXAppliedIndicator(line.substring(24, 25));
            merchantDataRecord.setLocalTax(line.substring(25, 37));
            merchantDataRecord.setLocalTaxIncluded(line.substring(37, 38));
            merchantDataRecord.setNationalTax(line.substring(38, 50));
            merchantDataRecord.setNationalTaxIncluded(line.substring(50, 51));
            merchantDataRecord.setTotalTaxesAmount(line.substring(51, 70));
            merchantDataRecord.setIndianIssuedCardRecurrentPaymentType(line.substring(70, 71));
            merchantDataRecord.setIndianIssuedCardRecurrentPaymentAmountIndicator(line.substring(71, 72));

            merchantDataRecord.setIndianIssuedCardRecurrentPaymentNumber(line.substring(72, 74));
            merchantDataRecord.setIndianIssuedCardRecurrentPaymentFrequency(line.substring(74, 76));
            merchantDataRecord.setIndianIssuedCardRecurrentRegistrationReferenceNumber(line.substring(76, 111));
            merchantDataRecord.setIndianIssuedCardMaximumRecurrentPaymentAmount(line.substring(111, 123));
            merchantDataRecord.setIndianIssuedCardRecurrentValidationIndicator(line.substring(123, 124));
            merchantDataRecord.setAgreementIDChoiceProgram(line.substring(124, 128));
            merchantDataRecord.setElectricVehicleConnectorType(line.substring(128, 131));
            merchantDataRecord.setElectricVehicleChargingReasonCode(line.substring(131, 134));
            merchantDataRecord.setReserved(line.substring(134, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Merchant Data 2: {}", e.getMessage());
            return merchantDataRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Merchant Data 2: {}", e.getMessage());
            return merchantDataRecord;
        }

        return merchantDataRecord;
    }

    public MerchantData3 parseMerchantData3(String line) {
        MerchantData3 merchantDataContdRecord = new MerchantData3();

        try {
            merchantDataContdRecord.setTransactionCode(line.substring(0, 2));
            merchantDataContdRecord.setTransactionCodeQualifier(line.substring(2, 3));
            merchantDataContdRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            merchantDataContdRecord.setMastercardAccountLevelManagementServiceData(line.substring(4, 34));
            merchantDataContdRecord.setMastercardAcceptorStreetAddress(line.substring(34, 82));
            merchantDataContdRecord.setMastercardAcceptorCountrySubdivisionCode(line.substring(82, 91));
            merchantDataContdRecord.setMastercardAcceptorCustomerServicePhoneNumber(line.substring(91, 107));
            merchantDataContdRecord.setMastercardServiceLocationCityName(line.substring(107, 157));
            merchantDataContdRecord.setMastercardServiceLocationStateProvinceCode(line.substring(157, 160));
            merchantDataContdRecord.setMastercardServiceLocationCountryCode(line.substring(160, 163));
            merchantDataContdRecord.setReserved(line.substring(163, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Merchant Data 3: {}", e.getMessage());
            return merchantDataContdRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Merchant Data 3: {}", e.getMessage());
            return merchantDataContdRecord;
        }

        return merchantDataContdRecord;
    }

    public GatewayDataContinuation parseGatewayDataContinuation(String line) {
        GatewayDataContinuation gatewayDataRecord = new GatewayDataContinuation();

        try {
            gatewayDataRecord.setTransactionCode(line.substring(0, 2));
            gatewayDataRecord.setTransactionCodeQualifier(line.substring(2, 3));
            gatewayDataRecord.setTransactionComponentSequenceNumber(line.substring(3, 4));
            gatewayDataRecord.setMastercardAcceptorURLAddress(line.substring(4, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Gateway Data Continuation: {}", e.getMessage());
            return gatewayDataRecord;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Gateway Data Continuation: {}", e.getMessage());
            return gatewayDataRecord;
        }

        return gatewayDataRecord;
    }

    public GatewayDataContinuation2 parseGatewayDataContinuation2(String line) {
        GatewayDataContinuation2 gatewayDataContd2Record = new GatewayDataContinuation2();

        try {
            gatewayDataContd2Record.setTransactionCode(line.substring(0, 2));
            gatewayDataContd2Record.setTransactionCodeQualifier(line.substring(2, 3));
            gatewayDataContd2Record.setTransactionComponentSequenceNumber(line.substring(3, 4));
            gatewayDataContd2Record.setMastercardAcceptorPhoneNumber(line.substring(4, 20));
            gatewayDataContd2Record.setMastercardAcceptorTaxID(line.substring(20, 55));
            gatewayDataContd2Record.setMastercardAcceptorPartnerIDCode(line.substring(55, 63));
            gatewayDataContd2Record.setMastercardServiceLocationPostalCode(line.substring(63, 72));
            gatewayDataContd2Record.setReserved(line.substring(72, 168));

        } catch (IndexOutOfBoundsException e) {
            log.warn("IndexOutOfBoundsException caught while parsing Gateway Data Continuation 2: {}", e.getMessage());
            return gatewayDataContd2Record;
        } catch (Exception e) {
            log.warn("Exception caught while parsing Gateway Data Continuation 2: {}", e.getMessage());
            return gatewayDataContd2Record;
        }

        return gatewayDataContd2Record;
    }


}
