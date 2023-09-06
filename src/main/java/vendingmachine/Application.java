package vendingmachine;

import vendingmachine.Controller.VendingMachineController;

public class Application {
    public static void main(String[] args) {
        VendingMachineController vendingMachine = new VendingMachineController();
        vendingMachine.vendingMachineProcess();
    }
}
