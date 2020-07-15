package lut.day25;

public class AutomTest {
    public static void main(String[] args) {
        Animal animal = new Animal();

    }
}
class  Animal implements Cloneable{

    public Animal() {
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Animal animal = new Animal();
        Object[] o = new Object[10];
        long l = System.currentTimeMillis();
        for(int i = 0;i<10;i++){
            o[i]= animal.clone();
            System.out.println(o[i]+"  "+i);
        }
        //  Animal animal1 = animal;
        long l2 = System.currentTimeMillis();
        for(int i = 0;i<10;i++){
            o[i]= animal;
            System.out.println(o[i]+"  "+i);
        }
        long l3 = System.currentTimeMillis();
        System.out.println(l2 - l);
        System.out.println(l3 - l2);

    }

}