package lut.day5.exe2;

public class Account {
    protected  double balance;//余额
    public Account(double balance){
        this.balance = balance;
    }
    public double getBalance(){
        return balance;
    }
    public boolean deposit(double amount){//存入金额
        double mon = balance;
        balance += amount;
        if(balance>mon)
            return true;
        else
            return  false;
    }
    public boolean withdraw(double amount){
        //取钱，amount为取出金额，如果amount>balance返回false，amount<=balance返回true
        if(amount>balance){
            return  false;
        } else{
            this.balance-=amount;
            return true;
        }

    }
}
