/*

                      +----------------------------+
                      |         Client (Main)      |
                      +----------------------------+
                                  |
                                  v
                      +----------------------------+
                      |   WeightMachineAdapter      |  <------  is-a
                      |       (Target)              |
                      +----------------------------+
                                  |
                                  v
                    +-----------------------------+
                    |  WeightMachineAdapterImpl   |  <------ has-a
                    +-----------------------------+
                                  |
                                  v
                  +-----------------------------------+
                  |      WeightMachineForBabies       |  <------ is-a
                  |         (Adaptee)                 |
                  +-----------------------------------+

Key Relationships:
- **has-a**: `WeightMachineAdapterImpl` has a `WeightMachine` reference.
- **is-a**: `WeightMachineAdapterImpl` is-a `WeightMachineAdapter`.
- **is-a**: `WeightMachineForBabies` is-a `WeightMachine`.


 */


package Client;

import Adaptee.WeightMachineForBabies;
import Adapter.WeightMachineAdapter;
import Adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}