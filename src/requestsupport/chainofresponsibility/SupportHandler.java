package requestsupport.chainofresponsibility;

import requestsupport.RequestType;
import requestsupport.SupportRequest;

public abstract class SupportHandler {
    protected SupportHandler nextHandler;
    protected RequestType handledType;
    protected String teamName;

    public SupportHandler(RequestType handledType, String teamName) {
        this.handledType = handledType;
        this.teamName = teamName;
    }

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public String handleRequest(SupportRequest request) {
        if (canHandle(request)) {
            return handle(request);
        } else if (nextHandler != null) {
            return nextHandler.handleRequest(request);
        }
        return "No handler available for this request type";
    }

    protected boolean canHandle(SupportRequest request) {
        return handledType.equals(request.getRequestType());
    }

    protected String handle(SupportRequest request) {
        return teamName + ": " + request.getRequestBody();
    }
}