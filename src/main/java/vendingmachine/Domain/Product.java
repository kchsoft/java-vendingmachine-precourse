package vendingmachine.Domain;

import vendingmachine.Validator.ProductValidator;

public class Product {

    private String name;
    private int price;
    private int cnt;


    public Product(String stringProduct) {
        stringProduct = stringProduct.substring(1, stringProduct.length() - 2);
        String[] productInfo = stringProduct.split(",");
        this.name = productInfo[0];
        this.price = Integer.parseInt(productInfo[1]);
        this.cnt = Integer.parseInt(productInfo[2]);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return price;
    }

    public void setCost(int price) {
        this.price = price;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
