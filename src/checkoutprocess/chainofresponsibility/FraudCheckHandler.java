package checkoutprocess.chainofresponsibility;

import checkoutprocess.PaymentData;
import checkoutprocess.PaymentResult;
import checkoutprocess.PaymentStatus;

public class FraudCheckHandler extends PaymentHandler {
    @Override
    public PaymentResult handle(PaymentData paymentData) {
        System.out.println("Fraud Check Step");

        // Fraud check logic
        boolean isFraudFree = paymentData.getAmount() < 10000;

        paymentData.setPassedFraudCheck(isFraudFree);
        System.out.println("Fraud Check: " + (isFraudFree ? "Success" : "Failed"));

        if (!isFraudFree) {
            return new PaymentResult(PaymentStatus.FRAUD_CHECK_FAILED,
                    "Payment failed: " + PaymentStatus.FRAUD_CHECK_FAILED.getMessage());
        }

        if (nextHandler != null) {
            return nextHandler.handle(paymentData);
        }

        return null; // Should not reach here
    }
}