public class PayToMerchantFlow extends PaymentFlow{
    @Override
    public void validateRequest() {
        // specific validation for PayToMerchantFlow flow
        System.out.println("validate logic of PayToMerchantFlow");
    }

    @Override
    public void debitAmount() {
        System.out.println("debit the amount logic of PayToMerchantFlow");
    }

    @Override
    public void calculateFee() {
        // specific Fee computation logic for PayToMerchantFlow flow
        System.out.println("2% fees charged");
    }

    @Override
    public void creditAmount() {
        // credit the amount logic
        System.out.println("credit the remaining amount");
    }
}
