package lut.day5.exe2;

public class Customer {
    private Account account;//账户
    private String name;//姓名
    public Customer(String name){
        this.name =name;
    }
    public String getName() {
        return name;
    }
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
