package lut.day5.exe2;

public class CheckingAccount extends Account{
    private double overdraft;//透支额度

    public CheckingAccount(double balance,double overdraft){
        super(balance);
        this.overdraft = overdraft;
    }
    public CheckingAccount(double balance) {
        super(balance);
        //设置透支额为0
        this.overdraft = 0;
    }
    public boolean withdraw(double amount){
        //取钱amount为取出金额，
        // 如果amount>balance+overdraft返回false，
        // amount<=balance+overdraft返回true
        if(amount>balance+overdraft){
            return  false;
        } else{
            this.balance-=amount;
            return true;
        }

    }

    public double getOverdraft() {
        return overdraft;
    }
}
