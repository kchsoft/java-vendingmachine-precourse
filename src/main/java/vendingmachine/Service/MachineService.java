package vendingmachine.Service;

import vendingmachine.Domain.Coin;
import vendingmachine.Domain.MachineInput;

import static vendingmachine.Constant.MachineGuideMsg.MACHINE_GUIDE_MACHINE_MONEY_USER_INPUT;

public class MachineService {
    public int inputMachineMoney() {
        int machineMoney = -1;
        while (machineMoney < 0) {
            System.out.println(MACHINE_GUIDE_MACHINE_MONEY_USER_INPUT);
            machineMoney = MachineInput.inputMoney();
        }
        return machineMoney;
    }
}
