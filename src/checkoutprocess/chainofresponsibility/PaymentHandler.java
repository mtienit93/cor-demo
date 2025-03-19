package checkoutprocess.chainofresponsibility;

import checkoutprocess.PaymentData;
import checkoutprocess.PaymentResult;

public abstract class PaymentHandler {
    protected PaymentHandler nextHandler;

    public void setNextHandler(PaymentHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract PaymentResult handle(PaymentData paymentData);
}