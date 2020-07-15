package lut.day10.lambda_able;

public class TestLambda {
    TestLambda (LambdaExe l){l.A();}
    TestLambda(ImplementsLambdaExe i){
        i.I(()->{
            System.out.println("55555");
            for(int b = 0;b<10;b++){
                System.out.print(b+"\t");
            }
        });
    }
    public static void main(String[] args) {
        new TestLambda(()->System.out.println("李佳钰吃的脸圆屁股大"));
        new TestLambda(new LambdaExe() {
            @Override
            public void A() {
                System.out.println("李佳钰打王者荣耀");
            }});
        new LambdaExe() {
            @Override
            public void A() {
                System.out.println("李佳钰不玩游戏了");
            }};
        LambdaExe l = new LambdaExe() {
            @Override
            public void A() { System.out.println("李佳钰爱玩吃鸡");}};
        new TestLambda(l);
        l.B();
        new TestLambda(new ImplementsLambdaExe());
    }
}
