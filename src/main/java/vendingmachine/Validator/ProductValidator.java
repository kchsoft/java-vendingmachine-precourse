package vendingmachine.Validator;

import vendingmachine.Domain.Product;

import java.util.HashMap;
import java.util.regex.Pattern;

import static vendingmachine.Constant.MachineErrMsg.*;

public class ProductValidator {
    public static void isStringToProductFormat(String stringProduct) throws IllegalArgumentException {
        String productPattern = "^\\[[^;,]+,\\d+,\\d+\\]$";
        Pattern compiled = Pattern.compile(productPattern);
        if (!compiled.matcher(stringProduct).matches())
            throw new IllegalArgumentException(ERR_MSG_PRODUCTS_INPUT_FORMAT_ILLEGAL);
    }

    public static void hasProductName(HashMap<String, Product> products, String productName) throws IllegalArgumentException {
        if (products.containsKey(productName)) return;
        throw new IllegalArgumentException(ERR_MSG_PRODUCT_NAME_NOT_FOUND);
    }

    public static void checkProductCnt(Product product) throws IllegalArgumentException {
        if (product.getCnt() > 0) return;
        throw new IllegalArgumentException(ERR_MSG_PRODUCT_STOCK_NOT_HAVE);
    }

    public static void checkProductPrice(int userMoney, int productPrice) throws IllegalArgumentException {
        if (userMoney - productPrice >= 0) return;
        throw new IllegalArgumentException(ERR_MSG_USER_MONEY_LACK);
    }
}
