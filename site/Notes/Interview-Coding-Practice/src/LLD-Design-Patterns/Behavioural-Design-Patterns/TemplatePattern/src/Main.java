/*
                            +-----------------------------------------------------------------+
                            |                       Template Design Pattern                   |
                            +-----------------------------------------------------------------+
                            |                                                                 |
                            |  PaymentFlow (Abstract Class): Defines the steps in a template  |
                            |  method "sendMoney" which subclasses must follow. Each step     |
                            |  (method) can be customized by subclasses, but the order of     |
                            |  steps is fixed.                                                |
                            |                                                                 |
                            +---------------------------------+-------------------------------+
                                                              |
                                                              v
                                               +-----------------------------+
                                               |   sendMoney()               |
                                               |   (template method)         |
                                               +-----------------------------+
                                                              |
                +-----------------------------------+---------+---------+--------------------+
                |                                   |                   |                    |
        +--------------------------+    +--------------------+   +------------------+    +-----------------------+
        | Step 1:                   |   | Step 2:            |   | Step 3:          |    | Step 4:               |
        | validateRequest()         |   | debitAmount()      |   | calculateFee()   |    | creditAmount()        |
        +--------------------------+    +--------------------+   +------------------+    +-----------------------+
                |                                   |                   |                           |
                v                                   v                   v                           v
        +-------------------------+  +------------------------+  +-------------------+   +-------------------------+
        | PayToFriend:            |  | PayToFriend:           |  | PayToFriend:      |   | PayToFriend:            |
        | Validate for friend     |  | Debit friend’s account |  | No fee (0%)       |   | Credit full amount      |
        +-------------------------+  +------------------------+  +-------------------+   +-------------------------+
                |                                   |                   |                           |
        +-------------------------+   +------------------------+  +-------------------+   +--------------------------+
        | PayToMerchantFlow:       |  | PayToMerchantFlow:     |  | PayToMerchant:    |   | PayToMerchantFlow:       |
        | Validate for merchant    |  | Debit merchant account |  | 2% fee charged    |   | Credit remaining amount  |
        +-------------------------+   +------------------------+  +-------------------+   +--------------------------+

            - The flow starts with `sendMoney()`, which calls the following steps in order:
                1. validateRequest() -> specific validation for friend or merchant.
                2. debitAmount() -> debits the respective amount.
                3. calculateFee() -> computes transaction fees (customized).
                4. creditAmount() -> credits money to the recipient.

            - Each subclass (PayToFriend, PayToMerchantFlow) customizes the behavior of each step but must follow the overall sequence.

*  Why its required and when to use?
*  whn you want all classes to follow the specific steps to process the task but also
*  Need to provide the flexibility that each class can have their own logic in that specific steps.
 */

public class Main {
    public static void main(String[] args) {
        PayToFriend obj = new PayToFriend();
        obj.sendMoney();
    }
}