package lut.day8;

public class TestInner {
    public static void main(String[] args) {
        new Cat("猫").catName(new Animal() {
            @Override
            public void animal(String name) {
                System.out.println("一只"+name);
            }
        });
       Animal animal =  new Animal() {
            @Override
            public void animal(String name) {
                System.out.println("一只"+name);
            }
        };
        new Cat("狗").catName(animal);
        Cat c = new Cat("fg"){
            public void sex(){
                System.out.println("大公猫");
            }
        };
        c.sex(c);
    }

}
