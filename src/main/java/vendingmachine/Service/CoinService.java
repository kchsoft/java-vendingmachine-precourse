package vendingmachine.Service;

import vendingmachine.Domain.Coin;

public class CoinService {


    public void dvideMoneyToCoins(int machineMoney) {
        for(Coin coin : Coin.values())
            machineMoney = dvideMoneyToEachCoin(machineMoney,coin);
    }
    private int dvideMoneyToEachCoin(int machineMoney,Coin coin) {
        int coinCnt = machineMoney / coin.getAmount();
        coin.setCnt(coinCnt);
        return machineMoney %= coin.getAmount();
    }
}
