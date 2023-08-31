package vendingmachine.Service;

import vendingmachine.Domain.Coin;
import vendingmachine.Domain.MachineInput;

import static vendingmachine.Constant.MachineGuideMsg.MACHINE_GUIDE_MACHINE_MONEY_USER_INPUT;
import static vendingmachine.Constant.MachineGuideMsg.MACHINE_GUIDE_MACHINE_PRODUCT_USER_INPUT;

public class MachineService {
    public int userInputMachineMoney() {
        int machineMoney = -1;
        while (machineMoney < 0) {
            System.out.println(MACHINE_GUIDE_MACHINE_MONEY_USER_INPUT);
            machineMoney = MachineInput.inputMoney();
        }
        return machineMoney;
    }

    public String[] userInputMachineProducts() {
        String[] stringProducts = null;
        while (stringProducts == null) {
            System.out.println(MACHINE_GUIDE_MACHINE_PRODUCT_USER_INPUT);
            stringProducts = MachineInput.inputProducts();
        }
        return stringProducts;
    }
}
