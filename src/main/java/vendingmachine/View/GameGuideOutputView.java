package vendingmachine.View;

import static vendingmachine.Constant.MachineDefaultValue.USER_MODE;
import static vendingmachine.Constant.MachineGuideMsg.MACHINE_GUIDE_MACHINE_MONEY_USER_INPUT;
import static vendingmachine.Constant.MachineGuideMsg.MACHINE_GUIDE_USER_MONEY_USER_INPUT;

public class GameGuideOutputView {
    public static void receiveMoneyGuideMsg(String Mode) {
        if (Mode.equals(USER_MODE)) {
            System.out.println(MACHINE_GUIDE_USER_MONEY_USER_INPUT);
            return;
        }
        System.out.println(MACHINE_GUIDE_MACHINE_MONEY_USER_INPUT);
        return;
    }
}
