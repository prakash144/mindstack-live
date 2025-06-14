public class PayToFriend extends PaymentFlow {
    @Override
    public void validateRequest() {
        // specific validation for PayToFriend flow
        System.out.println("validate logic of payToFriend");
    }

    @Override
    public void debitAmount() {
        System.out.println("debit the amount logic of payToFriend");
    }

    @Override
    public void calculateFee() {
        // specific Fee computation logic for PayToFriend flow
        System.out.println("0% fees charged");
    }

    @Override
    public void creditAmount() {
        // credit the amount logic
        System.out.println("credit the full amount");
    }
}
