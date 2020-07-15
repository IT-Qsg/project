package lut.day9.lambdaable;

public class RandomTest {
    public static void main(String[] args) {
       RandomNumAble f =()->{System.out.println("lambda表达式");};
        //RandomNumAble d =(System.out::println);
        f.num();
    }

}
