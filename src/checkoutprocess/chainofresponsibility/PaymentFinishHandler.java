package checkoutprocess.chainofresponsibility;

import checkoutprocess.PaymentData;
import checkoutprocess.PaymentResult;
import checkoutprocess.PaymentStatus;

public class PaymentFinishHandler extends PaymentHandler {
    @Override
    public PaymentResult handle(PaymentData paymentData) {
        System.out.println("Payment Finish Step");

        // Payment finalization logic
        System.out.println("Payment Finish: Payment completed successfully");

        return new PaymentResult(PaymentStatus.SUCCESS,
                "Payment for $" + paymentData.getAmount() + " processed successfully");
    }
}