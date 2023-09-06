package vendingmachine.View;

import vendingmachine.Domain.Coin;

import static vendingmachine.Constant.MachineGuideMsg.*;

public class CoinOutputView {

    public static void printMachineCoin() {
        System.out.println(MACHINE_GUIDE_MACHINE_MONEY_HAVE_COIN);
        for(Coin coin : Coin.values())
            coinView(coin);
    }

    public static void printMachineCoin(int userMoney) {
        System.out.println(MACHINE_GUIDE_MACHINE_MONEY_HAVE_COIN);
        for(Coin coin : Coin.values())
            coinView(coin);
    }
    private static void coinView(Coin coin) {
        System.out.printf(MACHINE_GUIDE_MACHINE_MONEY_COIN_VIEW, coin.getAmount(),coin.getCnt());
    }

}
