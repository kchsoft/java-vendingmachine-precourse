package vendingmachine.Validator;

import vendingmachine.Domain.Product;

import static vendingmachine.Constant.MachineDefaultValue.PRODUCT_CNT_INDEX;
import static vendingmachine.Constant.MachineDefaultValue.PRODUCT_PRICE_INDEX;

public class InputValidator {

    public static void isValidCoin(String stringMoney) throws IllegalArgumentException {
        CoinValidator.isStringtoInteger(stringMoney);
        int money = Integer.parseInt(stringMoney);
        CoinValidator.isCorrectMoneyUnit(money);
    }

    private static void isValidProductPrice(String stringMoney) throws IllegalArgumentException {
        CoinValidator.isStringtoInteger(stringMoney);
        int money = Integer.parseInt(stringMoney);
        CoinValidator.isCorrectMoneyUnit(money);
        CoinValidator.isMinPriceOver(money);
    }

    public static void isProductFormat(String[] stringProducts) throws IllegalArgumentException {
        String[] stringProductInfo;
        for (String stringProduct : stringProducts) {
            ProductValidator.isStringToProductFormat(stringProduct);
            stringProductInfo = Product.getStringProductInfo(stringProduct);
            isValidProductPrice(stringProductInfo[PRODUCT_PRICE_INDEX]);
        }
    }
}
