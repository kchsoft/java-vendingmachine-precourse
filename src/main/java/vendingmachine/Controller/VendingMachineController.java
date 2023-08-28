package vendingmachine.Controller;

import vendingmachine.Service.VendingService;

public class VendingMachineController {

    VendingService vendingService;

    public VendingMachineController() {
        this.vendingService = new VendingService();
    }



    public void machineStart() {
        vendingProcess();
    }

    private void vendingProcess() {
        int machineMoney = -1;
        while (machineMoney < 0) {
            machineMoney = vendingService.inputMoney();
        }
    }
}
