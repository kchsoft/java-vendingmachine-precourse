package vendingmachine.Validator;

import vendingmachine.Domain.Product;

import java.util.HashMap;

import static vendingmachine.Constant.MachineDefaultValue.PRODUCT_CNT_INDEX;
import static vendingmachine.Constant.MachineDefaultValue.PRODUCT_PRICE_INDEX;

public class InputValidator {

    public static void isValidCoin(String stringMoney) throws IllegalArgumentException {
        CoinValidator.isStringtoInteger(stringMoney);
        int money = Integer.parseInt(stringMoney);
        CoinValidator.isCorrectMoneyUnit(money);
    }

    private static void isValidProductPriceFormat(String stringMoney) throws IllegalArgumentException {
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
            isValidProductPriceFormat(stringProductInfo[PRODUCT_PRICE_INDEX]);
        }
    }
    public static void isVallidProduct(HashMap<String,Product> products,String productName)throws IllegalArgumentException {
        ProductValidator.hasProductName(products,productName);
        Product product = products.get(productName);
        ProductValidator.checkProductCnt(product);
    }
}
