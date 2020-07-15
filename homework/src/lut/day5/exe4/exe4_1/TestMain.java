package lut.day5.exe4.exe4_1;

public class TestMain{
	public static void main(String args[]){
		MyClass mc1 = new MyClass();
		MyClass mc2 = new MyClass();
		mc1.a = 100;
		mc1.b = 200;
		mc2.a = 300;
		mc2.b = 400;
		System.out.println(mc1.a);//300
		System.out.println(mc1.b);//200
		System.out.println(mc2.a);//300
		System.out.println(mc2.b);//400
	}
}