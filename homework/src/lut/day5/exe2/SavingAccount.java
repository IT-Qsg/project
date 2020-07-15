package lut.day5.exe2;

public class SavingAccount extends  Account{
    private  double rate;//利率

    public SavingAccount(double balance,double rate) {
        super(balance);
        this.rate = rate;
    }
}

