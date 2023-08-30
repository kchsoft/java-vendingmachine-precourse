package vendingmachine.Controller;

import vendingmachine.Domain.Coin;
import vendingmachine.Service.CoinService;
import vendingmachine.Service.MachineService;
import vendingmachine.View.CoinOutputView;

public class VendingMachineController {

    MachineService machineService;
    CoinService coinService;

    public VendingMachineController() {
        this.machineService = new MachineService();
        this.coinService = new CoinService();
    }


    public void machineStart() {
        vendingMachineProcess();
    }

    private void vendingMachineProcess() {
        int machineMoney = machineService.inputMachineMoney();
        coinService.dvideMoneyToRandomCoins(machineMoney);
        CoinOutputView.printMachineCoin();
        String[] stringProduct = machineService.inputMachineProducts();
        for (String s : stringProduct) {
            System.out.println("s = " + s);
        }
    }
}
