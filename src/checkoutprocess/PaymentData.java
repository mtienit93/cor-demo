package checkoutprocess;

public class PaymentData {
    private String cardNumber;
    private String cardholderName;
    private String expiryDate;
    private String cvv;
    private double amount;
    private boolean isAuthenticated = false;
    private boolean passedFraudCheck = false;
    private boolean hasSufficientCredit = false;
    private boolean isProcessed = false;

    // Getters and setters
    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getCardholderName() { return cardholderName; }
    public void setCardholderName(String cardholderName) { this.cardholderName = cardholderName; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

    public String getCvv() { return cvv; }
    public void setCvv(String cvv) { this.cvv = cvv; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public boolean isAuthenticated() { return isAuthenticated; }
    public void setAuthenticated(boolean authenticated) { isAuthenticated = authenticated; }

    public boolean isPassedFraudCheck() { return passedFraudCheck; }
    public void setPassedFraudCheck(boolean passedFraudCheck) { this.passedFraudCheck = passedFraudCheck; }

    public boolean isHasSufficientCredit() { return hasSufficientCredit; }
    public void setHasSufficientCredit(boolean hasSufficientCredit) { this.hasSufficientCredit = hasSufficientCredit; }

    public boolean isProcessed() { return isProcessed; }
    public void setProcessed(boolean processed) { isProcessed = processed; }
}