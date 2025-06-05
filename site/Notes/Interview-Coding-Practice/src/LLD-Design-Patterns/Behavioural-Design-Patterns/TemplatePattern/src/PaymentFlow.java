public abstract class PaymentFlow {
    public abstract void validateRequest();
    public abstract void debitAmount();
    public abstract void calculateFee();
    public abstract void creditAmount();

    // This is Template method: which defines the order of steps to execute the task.
    public final void sendMoney(){
        // step 1
        validateRequest();
        // step 2
        debitAmount();
        // step 3
        calculateFee();
        // step 4
        creditAmount();
    }
}
