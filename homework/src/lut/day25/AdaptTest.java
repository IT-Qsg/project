package lut.day25;

public class AdaptTest {
}
interface Duck{
    void runD();
    void cryD();
}
class YelloDuck implements Duck{

    @Override
    public void runD() {
        System.out.println("黄鸭子跑");
    }

    @Override
    public void cryD() {
        System.out.println("黄鸭子叫");
    }
}
interface Chicken{
    void run();
    void cry();
}
class RedChicken implements Chicken{
    @Override
    public void run() {
        System.out.println("火鸡跑");
    }

    @Override
    public void cry() {
        System.out.println("火鸡叫");
    }
}
//火鸡变鸭子
class RedDuck extends RedChicken implements Duck{

    @Override
    public void runD() {
        super.run();
    }

    @Override
    public void cryD() {
        super.cry();
    }

    public static void main(String[] args) {
        Duck redDuck = new RedDuck();
        redDuck.runD();
        redDuck.cryD();
    }
}