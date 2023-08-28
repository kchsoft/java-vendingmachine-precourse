package vendingmachine.Service;

import vendingmachine.Validator.InputValidator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class VendingService {
    public int inputMoney() {
        String stringMoney = readLine();

        try{
            InputValidator.isStringtoInteger(stringMoney);
            return Integer.parseInt(stringMoney);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
