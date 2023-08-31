package vendingmachine.Domain;

import vendingmachine.Validator.ProductValidator;

public class Product {

    private String name;
    private int price;
    private int cnt;


    public Product(String stringProduct) {
        String[] productInfo = getStringProductInfo(stringProduct);
        this.name = productInfo[0];
        this.price = Integer.parseInt(productInfo[1]);
        this.cnt = Integer.parseInt(productInfo[2]);
    }

    public static String[] getStringProductInfo(String stringProduct) {
        stringProduct = stringProduct.substring(1, stringProduct.length() - 1);
        return stringProduct.split(",");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
