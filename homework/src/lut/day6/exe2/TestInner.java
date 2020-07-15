package lut.day6.exe2;
//内部类练习
public class TestInner {
    public void A(Shap s){
        s.R();
        System.out.println(" A ");
    }
    AbstractClass abs = new AbstractClass() {
        @Override
        public int B() {
            System.out.println("AbstractClass   B");
            return 0;
        }
    };
    Shap sh = new Shap() {
        @Override
        public void R() {
            System.out.println("Shap  R");
        }
    };
    public static void main(String... arge){
        TestInner t = new TestInner();
        t.A(new Shap() {
            @Override
            public void R() {
                System.out.println("Shap    R...");
            }
        });
        t.abs.B();
        t.sh.R();

    }
}
