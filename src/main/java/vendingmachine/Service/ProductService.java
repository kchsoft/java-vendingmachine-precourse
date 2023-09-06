package vendingmachine.Service;

import vendingmachine.Domain.MachineInput;
import vendingmachine.Domain.Product;
import vendingmachine.Validator.ProductValidator;

import java.util.HashMap;
import java.util.Set;

import static vendingmachine.Constant.MachineGuideMsg.MACHINE_GUIDE_MACHINE_PRODUCT_USER_INPUT;

public class ProductService {

    public HashMap<String, Product> setProducts() {
        String[] stringProducts = null;
        while (stringProducts == null) {
            System.out.println(MACHINE_GUIDE_MACHINE_PRODUCT_USER_INPUT);
            stringProducts = MachineInput.registerProducts();
        }
        return makeStringToProduct(stringProducts);
    }

    private HashMap<String, Product> makeStringToProduct(String[] stringProducts) {
        HashMap<String, Product> products = new HashMap<>();
        for (String stringProduct : stringProducts) {
            Product p = new Product(stringProduct);
            products.put(p.getName(), p);
        }
        return products;
    }

    public int findMinProductPrice(HashMap<String, Product> products) {
        Set<String> key = products.keySet();
        int minPrice = Integer.MAX_VALUE;
        int productPrice;
        Product product;
        for (String productName : key) {
            product = products.get(productName);
            productPrice = product.getPrice();
            if (minPrice > productPrice)
                minPrice = productPrice;
        }
        return minPrice;
    }

    public int sellProducts(int userMoney, HashMap<String, Product> products) {
        Product sellingproduct = MachineInput.choiceProduct(products);
        if (sellingproduct == null) return userMoney;

        sellingproduct.setCnt(sellingproduct.getCnt() - 1);
        int productPrice = sellingproduct.getPrice();

        if (!purchasePriceCheck(userMoney, productPrice)) return userMoney;

        return userMoney - productPrice;
    }

    private boolean purchasePriceCheck(int userMoney, int productPrice) {
        try {
            ProductValidator.checkProductPrice(userMoney, productPrice);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean checkProductStock(HashMap<String, Product> products) {
        Set<String> keySet = products.keySet();
        boolean isProductExist = false;
        Product product;
        for (String key : keySet) {
            product = products.get(key);
            if(product.getCnt() >= 1) isProductExist = true;
        }
        return isProductExist;
    }
}
