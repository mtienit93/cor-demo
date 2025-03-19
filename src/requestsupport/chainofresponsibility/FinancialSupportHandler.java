package requestsupport.chainofresponsibility;

import requestsupport.RequestType;

public class FinancialSupportHandler extends SupportHandler {
    public FinancialSupportHandler() {
        super(RequestType.FINANCIAL, "Finance Support Team");
    }
}