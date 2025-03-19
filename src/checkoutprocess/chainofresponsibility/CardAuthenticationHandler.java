package checkoutprocess.chainofresponsibility;

import checkoutprocess.PaymentData;
import checkoutprocess.PaymentResult;
import checkoutprocess.PaymentStatus;

public class CardAuthenticationHandler extends PaymentHandler {
    @Override
    public PaymentResult handle(PaymentData paymentData) {
        System.out.println("Card Authentication Step");

        // Validate card details
        boolean isValid = !paymentData.getCardNumber().isEmpty() &&
                !paymentData.getExpiryDate().isEmpty() &&
                !paymentData.getCvv().isEmpty();

        paymentData.setAuthenticated(isValid);
        System.out.println("Card Authentication: " + (isValid ? "Success" : "Failed"));

        if (!isValid) {
            return new PaymentResult(PaymentStatus.AUTHENTICATION_FAILED,
                    "Payment failed: " + PaymentStatus.AUTHENTICATION_FAILED.getMessage());
        }

        if (nextHandler != null) {
            return nextHandler.handle(paymentData);
        }

        return null; // Should not reach here
    }
}