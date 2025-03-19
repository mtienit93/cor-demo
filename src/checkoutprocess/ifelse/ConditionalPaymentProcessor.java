package checkoutprocess.ifelse;

import checkoutprocess.PaymentData;
import checkoutprocess.PaymentResult;
import checkoutprocess.PaymentStatus;

public class ConditionalPaymentProcessor {
    public PaymentResult processPayment(PaymentData paymentData) {
        // Step 1: Card Authentication
        if (!authenticateCard(paymentData)) {
            return new PaymentResult(PaymentStatus.AUTHENTICATION_FAILED,
                    "Payment failed: " + PaymentStatus.AUTHENTICATION_FAILED.getMessage());
        }

        // Step 2: Fraud Check
        if (!checkFraud(paymentData)) {
            return new PaymentResult(PaymentStatus.FRAUD_CHECK_FAILED,
                    "Payment failed: " + PaymentStatus.FRAUD_CHECK_FAILED.getMessage());
        }

        // Step 3: Credit Check
        if (!checkCredit(paymentData)) {
            return new PaymentResult(PaymentStatus.INSUFFICIENT_CREDIT,
                    "Payment failed: " + PaymentStatus.INSUFFICIENT_CREDIT.getMessage());
        }

        // Step 4: Payment Processing
        if (!processTransaction(paymentData)) {
            return new PaymentResult(PaymentStatus.PROCESSING_FAILED,
                    "Payment failed: " + PaymentStatus.PROCESSING_FAILED.getMessage());
        }

        // Step 5: Payment Finish
        return finishPayment(paymentData);
    }

    private boolean authenticateCard(PaymentData paymentData) {
        // Simulate card authentication logic
        boolean isValid = !paymentData.getCardNumber().isEmpty() &&
                !paymentData.getExpiryDate().isEmpty() &&
                !paymentData.getCvv().isEmpty();

        paymentData.setAuthenticated(isValid);
        System.out.println("Card Authentication: " + (isValid ? "Success" : "Failed"));
        return isValid;
    }

    private boolean checkFraud(PaymentData paymentData) {
        // Simulate fraud check logic
        // For demo, consider transactions below $10,000 as non-fraudulent
        boolean isFraudFree = paymentData.getAmount() < 10000;

        paymentData.setPassedFraudCheck(isFraudFree);
        System.out.println("Fraud Check: " + (isFraudFree ? "Success" : "Failed"));
        return isFraudFree;
    }

    private boolean checkCredit(PaymentData paymentData) {
        // Simulate credit check logic
        // For demo, consider all transactions above $1 as having sufficient credit
        boolean hasSufficientCredit = paymentData.getAmount() > 0;

        paymentData.setHasSufficientCredit(hasSufficientCredit);
        System.out.println("Credit Check: " + (hasSufficientCredit ? "Success" : "Failed"));
        return hasSufficientCredit;
    }

    private boolean processTransaction(PaymentData paymentData) {
        // Simulate payment gateway processing
        // For demo purposes, consider all transactions processing successfully
        boolean isProcessed = true;

        paymentData.setProcessed(isProcessed);
        System.out.println("Payment Processing: " + "Success");
        return isProcessed;
    }

    private PaymentResult finishPayment(PaymentData paymentData) {
        // Finalize payment
        System.out.println("Payment Finish: Payment completed successfully");
        return new PaymentResult(PaymentStatus.SUCCESS,
                "Payment for $" + paymentData.getAmount() + " processed successfully");
    }
}