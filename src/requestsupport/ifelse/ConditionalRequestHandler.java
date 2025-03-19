package requestsupport.ifelse;

import requestsupport.RequestType;
import requestsupport.SupportRequest;

public class ConditionalRequestHandler {
    public String handleRequest(SupportRequest request) {
        if (RequestType.ACCOUNT.equals(request.getRequestType())) {
            return "Customer Support Team: " + request.getRequestBody();
        } else if (RequestType.TECHNICAL.equals(request.getRequestType())) {
            return "Technical Support Team: " + request.getRequestBody();
        } else if (RequestType.FINANCIAL.equals(request.getRequestType())) {
            return "Finance Support Team: " + request.getRequestBody();
        } else {
            return "General Support Team: " + request.getRequestBody();
        }
    }
}