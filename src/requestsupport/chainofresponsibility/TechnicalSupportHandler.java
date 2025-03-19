package requestsupport.chainofresponsibility;

import requestsupport.RequestType;

public class TechnicalSupportHandler extends SupportHandler {
    public TechnicalSupportHandler() {
        super(RequestType.TECHNICAL, "Technical Support Team");
    }
}