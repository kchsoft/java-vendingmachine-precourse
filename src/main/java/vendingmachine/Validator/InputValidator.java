package vendingmachine.Validator;

import java.util.regex.Pattern;
import static vendingmachine.Constant.VendingErrMsg.ERR_MSG_MONEY_INPUT_NOT_NUBMER;

public class InputValidator {

    public static void isStringtoInteger(String inputMoney)throws IllegalArgumentException {
        String integerPattern = "^[0-9]+$";
        Pattern compiled = Pattern.compile(integerPattern);
        if(!compiled.matcher(inputMoney).matches()) throw new IllegalArgumentException(ERR_MSG_MONEY_INPUT_NOT_NUBMER);
    }
}
