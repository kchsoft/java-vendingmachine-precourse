package vendingmachine.Service;

import vendingmachine.Domain.Coin;
import vendingmachine.Domain.MachineInput;
import vendingmachine.View.GameGuideOutputView;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;


public class CoinService {

    public int receiveMoney(String Mode) {
        int machineMoney = -1;
        while (machineMoney < 0) {
            GameGuideOutputView.receiveMoneyGuideMsg(Mode);
            machineMoney = MachineInput.inputMoney();
        }
        return machineMoney;
    }
    private void makeCoinList(List<Integer> coinAmountList) {
        coinAmountList.add(Coin.COIN_500.getAmount());
        coinAmountList.add(Coin.COIN_100.getAmount());
        coinAmountList.add(Coin.COIN_50.getAmount());
        coinAmountList.add(Coin.COIN_10.getAmount());
    }

    public void dvideMoneyToRandomCoins(int machineMoney) {
        int randAmount;
        List<Integer> coinAmountList = new ArrayList<Integer>();
        makeCoinList(coinAmountList);
        while (machineMoney != 0) {
            randAmount = pickNumberInList(coinAmountList);
            machineMoney = minusRandCoinAmount(machineMoney,randAmount);
        }
        return;
    }

    private int minusRandCoinAmount(int machineMoney, int amount) {
        if(machineMoney - amount < 0) return machineMoney;
        Coin coin = Coin.valueOf("COIN_" + amount);
        coin.plusOneCnt();
        return machineMoney - amount;
    }
}
