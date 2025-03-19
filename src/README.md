# Chain of Responsibility Pattern Demo

This project demonstrates the implementation and advantages of the Chain of Responsibility design pattern compared to traditional if-else conditional logic in Java.

## Project Overview

This demo application showcases two different approaches to handling:

1. **Customer Support Request Processing**
2. **Payment Processing in a Checkout System**

Each system is implemented using both:
- Traditional conditional (if-else) approach
- Chain of Responsibility design pattern

## Key Components

### Support Request Handler

Handles different types of support requests:
- Account issues
- Technical problems
- Financial inquiries
- Other general requests

### Payment Processor

Processes payments through several validation steps:
- Card authentication
- Fraud detection
- Credit verification
- Transaction processing

## Design Pattern Benefits

The Chain of Responsibility pattern offers several advantages:
- **Decoupling**: Each handler operates independently
- **Single Responsibility**: Each handler focuses on one specific task
- **Flexibility**: Easily add or reorder processing steps
- **Open/Closed Principle**: Extend functionality without modifying existing code

## Running the Demo

The `Main` class contains test scenarios for both approaches. Uncomment the relevant sections to test:
- Support request handling with if-else vs chain of responsibility
- Payment processing with if-else vs chain of responsibility

## Project Structure

- `src/checkoutprocess/`: Payment processing implementations
  - `ifelse/`: Traditional conditional approach
  - `chainofresponsibility/`: Chain of Responsibility pattern implementation
- `src/requestsupport/`: Support request handling implementations
  - `ifelse/`: Traditional conditional approach
  - `chainofresponsibility/`: Chain of Responsibility pattern implementation

## How to Use

1. Run the `Main` class
2. Review the console output to compare both implementation approaches
3. Experiment by modifying the test data or uncommenting different test sections