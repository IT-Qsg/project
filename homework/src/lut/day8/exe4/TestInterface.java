package lut.day8.exe4;

public class TestInterface {
    public interface A{
        void B();
    }
    static class C implements A{
        @Override
        public void B() {
            System.out.println("B 方法");
        }
    }
    public static void main(String[] args) {
        new TestInterface.C().B();
    }
}
