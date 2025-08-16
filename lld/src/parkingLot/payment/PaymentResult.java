package parkingLot.payment;

public class PaymentResult {

    private String transactionId;
    private String message;
    private PaymentStatus status;
    public PaymentResult(String transactionId, String message, PaymentStatus status) {
        this.transactionId = transactionId;
        this.message = message;
        this.status = status;
    }
    public String getTransactionId() {
        return transactionId;
    }

    public String getMessage() {
        return message;
    }
    public PaymentStatus getStatus() {
        return status;
    }

    public boolean isSuccess() {
        return status == PaymentStatus.SUCCESS;
    }
}
