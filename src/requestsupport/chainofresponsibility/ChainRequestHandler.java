package requestsupport.chainofresponsibility;

import requestsupport.SupportRequest;

public class ChainRequestHandler {
    private final SupportHandler handler;

    public ChainRequestHandler() {
        // Create handlers
        SupportHandler accountHandler = new AccountSupportHandler();
        SupportHandler technicalHandler = new TechnicalSupportHandler();
        SupportHandler financialHandler = new FinancialSupportHandler();
        SupportHandler generalHandler = new GeneralSupportHandler();

        // Set up the chain
        accountHandler.setNextHandler(technicalHandler);
        technicalHandler.setNextHandler(financialHandler);
        financialHandler.setNextHandler(generalHandler);

        // Start of the chain
        this.handler = accountHandler;
    }

    public String handleRequest(SupportRequest request) {
        return handler.handleRequest(request);
    }
}