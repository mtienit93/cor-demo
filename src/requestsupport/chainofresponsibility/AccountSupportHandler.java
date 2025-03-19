package requestsupport.chainofresponsibility;

import requestsupport.RequestType;

public class AccountSupportHandler extends SupportHandler {
    public AccountSupportHandler() {
        super(RequestType.ACCOUNT, "Customer Support Team");
    }
}