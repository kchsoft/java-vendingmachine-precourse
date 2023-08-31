package vendingmachine.Service;

import vendingmachine.Domain.MachineInput;
import vendingmachine.Domain.Product;
import vendingmachine.View.GameGuideOutputView;

import java.util.HashMap;

import static vendingmachine.Constant.MachineGuideMsg.*;

public class MachineService {
    public int receiveMoney(String Mode) {
        int machineMoney = -1;
        while (machineMoney < 0) {
            GameGuideOutputView.receiveMoneyGuideMsg(Mode);
            machineMoney = MachineInput.inputMoney();
        }
        return machineMoney;
    }

    public HashMap<String, Product> setProducts() {
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
