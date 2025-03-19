package checkoutprocess;

public enum PaymentStatus {
    SUCCESS("Payment successful"),
    AUTHENTICATION_FAILED("Card authentication failed"),
    FRAUD_CHECK_FAILED("Fraud check failed"),
    INSUFFICIENT_CREDIT("Insufficient credit"),
    PROCESSING_FAILED("Payment processing failed");

    private final String message;

    PaymentStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}