package checkoutprocess.chainofresponsibility;

import checkoutprocess.PaymentData;
import checkoutprocess.PaymentResult;
import checkoutprocess.PaymentStatus;

public class CreditCheckHandler extends PaymentHandler {
    @Override
    public PaymentResult handle(PaymentData paymentData) {
        System.out.println("Credit Check Step");

        // Credit check logic
        boolean hasSufficientCredit = paymentData.getAmount() > 0;

        paymentData.setHasSufficientCredit(hasSufficientCredit);
        System.out.println("Credit Check: " + (hasSufficientCredit ? "Success" : "Failed"));

        if (!hasSufficientCredit) {
            return new PaymentResult(PaymentStatus.INSUFFICIENT_CREDIT,
                    "Payment failed: " + PaymentStatus.INSUFFICIENT_CREDIT.getMessage());
        }

        if (nextHandler != null) {
            return nextHandler.handle(paymentData);
        }

        return null; // Should not reach here
    }
}