package vendingmachine.Domain;

import vendingmachine.Validator.ProductValidator;
import vendingmachine.Validator.InputValidator;

import java.util.HashMap;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class MachineInput {

    public static int inputMoney() {
        String stringMoney = readLine();
        try {
            InputValidator.isValidCoin(stringMoney);
            return Integer.parseInt(stringMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static String[] registerProducts() {
        String stringProdct = readLine();
        String[] stringProducts = stringProdct.split(";");
        try {
            InputValidator.isProductFormat(stringProducts);
            return stringProducts;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Product choiceProduct(HashMap<String,Product> products) {
        String productName = readLine();
        try {
            InputValidator.isVallidProduct(products,productName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return products.get(productName);
    }
}
