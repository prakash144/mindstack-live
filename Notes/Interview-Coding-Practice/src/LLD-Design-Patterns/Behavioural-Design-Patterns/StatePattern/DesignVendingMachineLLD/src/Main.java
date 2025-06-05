/**
 *
 *            +---------------+                    +---------------+
 *           |   Idle State   | --Insert Coin-->  | Has Money State|
 *           +---------------+                    +---------------+
 *                 ^                                      |
 *                 |                                      v
 *       Refund <--|                           Click Product Selection
 *                 |                                      |
 *                 v                                      |
 *         +-----------------+                            +----------------+
 *         | Selection State | --Sufficient Amount-->    | Dispense State  |
 *         +----------------+                            +----------------+
 *                                                          |
 *                                                Product Dispensed, Change Returned
 *                                                          v
 *                                                     +-------------+
 *                                                    |  Idle State  |
 *                                                    +-------------+
 *
 *
 * Vending Machine State Design Pattern
 * - Uses the State pattern to manage different vending machine states (Idle, HasMoney, Selection, Dispense)
 * - VendingMachine context holds a reference to the current state (State interface implementation)
 * - Transitions between states occur based on user actions (insert coin, select product, etc.)
 * - Each state defines its own behavior and possible state transitions
 * - States: IdleState (waiting for coin), HasMoneyState (accepting coins), SelectionState (product selection), DispenseState (dispensing product)
 * - The machine can move between these states to manage product vending and coin handling
 */


import VendingOperations.*;
import VendingStates.State;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        try {
            System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("clicking on InsertCoinButton");
            System.out.println("|");

            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoin(vendingMachine, Coin.NICKEL);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);
            // vendingState.insertCoin(vendingMachine, Coin.NICKEL);

            System.out.println("|");
            System.out.println("clicking on ProductSelectionButton");
            System.out.println("|");
            vendingState.clickOnStartProductSelectionButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine, 102);

            displayInventory(vendingMachine);


        } catch (Exception e) {
            displayInventory(vendingMachine);
        }
    }

    private static void fillUpInventory(VendingMachine vendingMachine){
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {
            Item newItem = new Item();
            if(i >=0 && i<3) {
                newItem.setType(ItemType.COKE);
                newItem.setPrice(12);
            }else if(i >=3 && i<5){
                newItem.setType(ItemType.PEPSI);
                newItem.setPrice(9);
            }else if(i >=5 && i<7){
                newItem.setType(ItemType.JUICE);
                newItem.setPrice(13);
            }else if(i >=7 && i<10){
                newItem.setType(ItemType.SODA);
                newItem.setPrice(7);
            }
            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){

        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {

            System.out.println("CodeNumber: " + slots[i].getCode() +
                    " Item: " + slots[i].getItem().getType().name() +
                    " Price: " + slots[i].getItem().getPrice() +
                    " isAvailable: " + !slots[i].isSoldOut());
        }
    }

}