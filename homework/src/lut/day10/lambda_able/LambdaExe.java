package lut.day10.lambda_able;

@FunctionalInterface
public interface LambdaExe {
    public abstract void A();
    //void C();
    default  void B(){
        System.out.println("石头感冒了");
    }
}
