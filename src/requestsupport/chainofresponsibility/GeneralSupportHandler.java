package requestsupport.chainofresponsibility;

import requestsupport.RequestType;
import requestsupport.SupportRequest;

public class GeneralSupportHandler extends SupportHandler {
    public GeneralSupportHandler() {
        super(RequestType.OTHER, "General Support Team");
    }

    @Override
    protected boolean canHandle(SupportRequest request) {
        // General handler accepts any remaining request
        return true;
    }
}