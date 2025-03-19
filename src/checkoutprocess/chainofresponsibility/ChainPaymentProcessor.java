package checkoutprocess.chainofresponsibility;

import checkoutprocess.PaymentData;
import checkoutprocess.PaymentResult;

public class ChainPaymentProcessor {
    private final PaymentHandler firstHandler;

    public ChainPaymentProcessor() {
        // Create handlers
        PaymentHandler authHandler = new CardAuthenticationHandler();
        PaymentHandler fraudHandler = new FraudCheckHandler();
        PaymentHandler creditHandler = new CreditCheckHandler();
        PaymentHandler processHandler = new PaymentProcessingHandler();
        PaymentHandler finishHandler = new PaymentFinishHandler();

        // Set up the chain
        authHandler.setNextHandler(fraudHandler);
        fraudHandler.setNextHandler(creditHandler);
        creditHandler.setNextHandler(processHandler);
        processHandler.setNextHandler(finishHandler);

        // First handler in the chain
        this.firstHandler = authHandler;
    }

    public PaymentResult processPayment(PaymentData paymentData) {
        return firstHandler.handle(paymentData);
    }
}