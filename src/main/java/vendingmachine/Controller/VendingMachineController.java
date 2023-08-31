package vendingmachine.Controller;

import vendingmachine.Domain.Product;
import vendingmachine.Service.CoinService;
import vendingmachine.Service.MachineService;
import vendingmachine.View.CoinOutputView;

import java.util.HashMap;

import static vendingmachine.Constant.MachineDefaultValue.MACHINE_MODE;
import static vendingmachine.Constant.MachineDefaultValue.USER_MODE;

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
        int machineMoney = machineService.receiveMoney(MACHINE_MODE);
        coinService.dvideMoneyToRandomCoins(machineMoney);
        CoinOutputView.printMachineCoin();
        HashMap<String, Product> products = machineService.setProducts();
        int userMoney = machineService.receiveMoney(USER_MODE);
    }
}
