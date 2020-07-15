package lut.day5.exe2;

public class Bank {
    private Customer[] customers;//客户
    private int custNum;//客户数量

    public Bank() {
        customers = new Customer[10];
    }
    public void addCustomer(Customer customer){
        customers[custNum] = customer;
        this.custNum++;
    }

    public Customer getCustomer(int index){
        return  customers[index];//获取指定位置的客户
    }
    public int getCustNum() {
        return custNum;
    }
}
