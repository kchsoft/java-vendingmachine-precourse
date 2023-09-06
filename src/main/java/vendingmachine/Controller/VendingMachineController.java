package vendingmachine.Controller;

import vendingmachine.Domain.Product;
import vendingmachine.Service.CoinService;
import vendingmachine.Service.ProductService;
import vendingmachine.View.CoinOutputView;

import java.util.HashMap;

import static vendingmachine.Constant.MachineDefaultValue.MACHINE_MODE;
import static vendingmachine.Constant.MachineDefaultValue.USER_MODE;

public class VendingMachineController {

    MachineService machineService;
    CoinService coinService;
    ProductService productService;

    public VendingMachineController() {
        this.machineService = new MachineService();
        this.coinService = new CoinService();
        this.productService = new ProductService();
    }


    public void vendingMachineProcess() {
        HashMap<String,Product> products = setMachineState();
        int userMoney = setUserMoney();
        vendProcess(userMoney,products);
    }

    private HashMap<String,Product> setMachineState() {
        int machineMoney = coinService.receiveMoney(MACHINE_MODE);
        coinService.dvideMoneyToRandomCoins(machineMoney);
        CoinOutputView.printMachineCoin();
        return productService.setProducts();
    }

    private int setUserMoney() {
        return coinService.receiveMoney(USER_MODE);
    }
    private void vendProcess(int userMoney, HashMap<String,Product> products) {
        int minProductPrice = productService.findMinProductPrice(products);
        boolean checkVendProcess = true;
        while (checkVendProcess) {
            System.out.printf("투입 금액: %d원\n",userMoney);
            System.out.println("투입 구매할 상품명을 입력해 주세요.");
            userMoney = productService.sellProducts(userMoney,products);
            if(userMoney < minProductPrice) checkVendProcess = false;
            if(!productService.checkProductStock(products)) checkVendProcess = false;
        }
    }
}
