package vendingmachine.Validator;

import net.bytebuddy.pool.TypePool;

import java.util.regex.Pattern;

import static vendingmachine.Constant.MachineErrMsg.ERR_MSG_PRODUCTS_INPUT_FORMAT_ILLEGAL;

public class ProductValidator {

    public static void isStringToProductFormat(String stringProduct) throws IllegalArgumentException{
        String productPattern = "^\\[[^;,]+,\\d+,\\d+\\]$";
        Pattern compiled = Pattern.compile(productPattern);
        if(!compiled.matcher(stringProduct).matches()) throw new IllegalArgumentException(ERR_MSG_PRODUCTS_INPUT_FORMAT_ILLEGAL);
    }
}
