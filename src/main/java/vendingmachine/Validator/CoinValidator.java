package vendingmachine.Validator;

import java.util.regex.Pattern;

import static vendingmachine.Constant.MachineDefaultValue.MACHINE_MINIMUM_PRICE;
import static vendingmachine.Constant.MachineDefaultValue.MACHINE_MONEY_UNIT;
import static vendingmachine.Constant.MachineErrMsg.*;

public class CoinValidator {
    public static void isStringtoInteger(String stringMoney)throws IllegalArgumentException {
        String integerPattern = "^[0-9]+$";
        Pattern compiled = Pattern.compile(integerPattern);
        if(!compiled.matcher(stringMoney).matches()) throw new IllegalArgumentException(ERR_MSG_MONEY_INPUT_NOT_NUBMER);
    }

    public static void isCorrectMoneyUnit(int money) {
        if(money % MACHINE_MONEY_UNIT == 0) return;
        throw new IllegalArgumentException(ERR_MSG_MONEY_INPUT_UNIT_IEELGAL);
    }

    public static void isMinPriceOver(int money) {
        if(money >= MACHINE_MINIMUM_PRICE) return;
        throw new IllegalArgumentException(ERR_MSG_MONEY_INPUT_MINIMUM_PRICE);
    }
}
