package vendingmachine.Validator;

import static vendingmachine.Constant.MachineDefaultValue.PRODUCT_CNT_INDEX;
import static vendingmachine.Constant.MachineDefaultValue.PRODUCT_PRICE_INDEX;

public class InputValidator {

    public static void isCorrectCoin(String stringMoney) throws IllegalArgumentException{
        CoinValidator.isStringtoInteger(stringMoney);
        int money = Integer.parseInt(stringMoney);
        CoinValidator.isCorrectMoneyUnit(money);
        CoinValidator.isMinPriceOver(money);
    }

    public static void isProductFormat(String[] stringProducts) throws IllegalArgumentException {
        String[] stringProductInfo;
        for (String stringProduct : stringProducts) {
            ProductValidator.isStringToProductFormat(stringProduct);
            stringProductInfo = getStringProductInfo(stringProduct);
            isCorrectCoin(stringProductInfo[PRODUCT_PRICE_INDEX]);
        }
    }

    private static String[] getStringProductInfo(String stringProduct) {
        stringProduct = stringProduct.substring(1, stringProduct.length() - 1);
       return stringProduct.split(",");
    }
}
