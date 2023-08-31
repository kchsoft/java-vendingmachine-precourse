package vendingmachine.Service;

import vendingmachine.Domain.MachineInput;
import vendingmachine.Domain.Product;

import java.util.HashMap;

import static vendingmachine.Constant.MachineGuideMsg.MACHINE_GUIDE_MACHINE_MONEY_USER_INPUT;
import static vendingmachine.Constant.MachineGuideMsg.MACHINE_GUIDE_MACHINE_PRODUCT_USER_INPUT;

public class MachineService {
    public int userInputMachineMoney() {
        int machineMoney = -1;
        while (machineMoney < 0) {
            System.out.println(MACHINE_GUIDE_MACHINE_MONEY_USER_INPUT);
            machineMoney = MachineInput.inputMoney();
        }
        return machineMoney;
    }

    public HashMap<String, Product> userInputMachineProducts() {
        String[] stringProducts = null;
        while (stringProducts == null) {
            System.out.println(MACHINE_GUIDE_MACHINE_PRODUCT_USER_INPUT);
            stringProducts = MachineInput.inputProducts();
        }
        return makeStringToProduct(stringProducts);
    }

    private HashMap<String,Product> makeStringToProduct(String[] stringProducts) {
        HashMap<String, Product> products = new HashMap<>();
        for (String stringProduct : stringProducts) {
            Product p = new Product(stringProduct);
            products.put(p.getName(), p);
        }
        return products;
    }
}
