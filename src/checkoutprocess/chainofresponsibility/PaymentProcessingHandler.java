package checkoutprocess.chainofresponsibility;

import checkoutprocess.PaymentData;
import checkoutprocess.PaymentResult;
import checkoutprocess.PaymentStatus;

public class PaymentProcessingHandler extends PaymentHandler {
    @Override
    public PaymentResult handle(PaymentData paymentData) {
        System.out.println("Payment Processing Step");

        // Payment processing logic
        boolean isProcessed = true;

        paymentData.setProcessed(isProcessed);
        System.out.println("Payment Processing: " + (isProcessed ? "Success" : "Failed"));

        if (!isProcessed) {
            return new PaymentResult(PaymentStatus.PROCESSING_FAILED,
                    "Payment failed: " + PaymentStatus.PROCESSING_FAILED.getMessage());
        }

        if (nextHandler != null) {
            return nextHandler.handle(paymentData);
        }

        return null; // Should not reach here
    }
}