import checkoutprocess.PaymentData;
import checkoutprocess.PaymentResult;
import checkoutprocess.chainofresponsibility.ChainPaymentProcessor;
import checkoutprocess.ifelse.ConditionalPaymentProcessor;
import requestsupport.RequestType;
import requestsupport.SupportRequest;
import requestsupport.chainofresponsibility.ChainRequestHandler;
import requestsupport.ifelse.ConditionalRequestHandler;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Request Support
//        // Create some test requests
//        SupportRequest accountRequest = createRequest(RequestType.ACCOUNT, "Can't login to my account");
//        SupportRequest technicalRequest = createRequest(RequestType.TECHNICAL, "Application crashes on startup");
//        SupportRequest financialRequest = createRequest(RequestType.FINANCIAL, "Need refund for subscription");
//        SupportRequest otherRequest = createRequest(RequestType.OTHER, "General inquiry about services");
//
//        // Using if-else approach
//        System.out.println("USING IF-ELSE APPROACH:");
//        ConditionalRequestHandler conditionalHandler = new ConditionalRequestHandler();
//        processRequest(conditionalHandler, accountRequest);
//        processRequest(conditionalHandler, technicalRequest);
//        processRequest(conditionalHandler, financialRequest);
//        processRequest(conditionalHandler, otherRequest);
//
//        System.out.println("\nUSING CHAIN OF RESPONSIBILITY PATTERN:");
//        // Using Chain of Responsibility
//        ChainRequestHandler chainHandler = new ChainRequestHandler();
//        processRequest(chainHandler, accountRequest);
//        processRequest(chainHandler, technicalRequest);
//        processRequest(chainHandler, financialRequest);
//        processRequest(chainHandler, otherRequest);

        //Checkout Process
        // Create payment data for testing
        PaymentData validPayment = createPaymentData(100.0, "4111111111111111", "123", "12/25");
        PaymentData invalidCardPayment = createPaymentData(100.0, "1234567890123456", "", "12/25");
        PaymentData fraudulentPayment = createPaymentData(11000.0, "4111111111111111", "999", "12/25"); // Using 999 as CVV to simulate fraud
        PaymentData insufficientCreditPayment = createPaymentData(0.0, "4111111111111111", "123", "12/25"); // Amount 0 to simulate insufficient credit

//        System.out.println("=== USING IF-ELSE APPROACH ===");
//        ConditionalPaymentProcessor conditionalProcessor = new ConditionalPaymentProcessor();
//
//        System.out.println("\n----- Processing Valid Payment -----");
//        PaymentResult result1 = conditionalProcessor.processPayment(validPayment);
//        displayResult(result1);
//
//        System.out.println("\n----- Processing Invalid Card Payment -----");
//        PaymentResult result2 = conditionalProcessor.processPayment(invalidCardPayment);
//        displayResult(result2);
//
//        System.out.println("\n----- Processing Fraudulent Payment -----");
//        PaymentResult result3 = conditionalProcessor.processPayment(fraudulentPayment);
//        displayResult(result3);
//
//        System.out.println("\n----- Processing Insufficient Credit Payment -----");
//        PaymentResult result4 = conditionalProcessor.processPayment(insufficientCreditPayment);
//        displayResult(result4);

        System.out.println("\n=== USING CHAIN OF RESPONSIBILITY PATTERN ===");
        ChainPaymentProcessor chainProcessor = new ChainPaymentProcessor();

        System.out.println("\n----- Processing Valid Payment -----");
        PaymentResult result5 = chainProcessor.processPayment(copyPaymentData(validPayment));
        displayResult(result5);

        System.out.println("\n----- Processing Invalid Card Payment -----");
        PaymentResult result6 = chainProcessor.processPayment(copyPaymentData(invalidCardPayment));
        displayResult(result6);

        System.out.println("\n----- Processing Fraudulent Payment -----");
        PaymentResult result7 = chainProcessor.processPayment(copyPaymentData(fraudulentPayment));
        displayResult(result7);

        System.out.println("\n----- Processing Insufficient Credit Payment -----");
        PaymentResult result8 = chainProcessor.processPayment(copyPaymentData(insufficientCreditPayment));
        displayResult(result8);
    }

    private static SupportRequest createRequest(RequestType type, String body) {
        SupportRequest request = new SupportRequest();
        request.setRequestType(type);
        request.setRequestBody(body);
        return request;
    }

    private static void processRequest(Object handler, SupportRequest request) {
        String result;
        if (handler instanceof ConditionalRequestHandler) {
            result = ((ConditionalRequestHandler) handler).handleRequest(request);
        } else {
            result = ((ChainRequestHandler) handler).handleRequest(request);
        }
        System.out.println("Request: " + request.getRequestType() + " - " + result);
    }

    private static PaymentData createPaymentData(double amount, String cardNumber, String cvv, String expiryDate) {
        PaymentData data = new PaymentData();
        data.setAmount(amount);
        data.setCardNumber(cardNumber);
        data.setCvv(cvv);
        data.setExpiryDate(expiryDate);
        return data;
    }

    private static void displayResult(PaymentResult result) {
        System.out.println("Status: " + result.getStatus());
        System.out.println("Message: " + result.getMessage());
    }

    private static PaymentData copyPaymentData(PaymentData original) {
        PaymentData copy = new PaymentData();
        copy.setAmount(original.getAmount());
        copy.setCardNumber(original.getCardNumber());
        copy.setCvv(original.getCvv());
        copy.setExpiryDate(original.getExpiryDate());
        return copy;
    }
}