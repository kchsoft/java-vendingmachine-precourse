package vendingmachine.Domain;

import vendingmachine.Validator.CoinValidator;
import vendingmachine.Validator.ProductValidator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class MachineInput {

    public static int inputMoney() {
        String stringMoney = readLine();
        try {
            CoinValidator.isStringtoInteger(stringMoney);
            return Integer.parseInt(stringMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static String[] inputProducts() {
        String stringProdct = readLine();
        String[] stringProducts = stringProdct.split(";");
        try {
            ProductValidator.isProductFormat(stringProducts);
            return stringProducts;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
