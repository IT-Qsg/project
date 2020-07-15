package lut.day7;

class ClassA{
	static {
		System.out.println("In ClassA Static");
}
	public ClassA(){
		System.out.println("ClassA()");
	}
}
class ClassB{
	static {
		System.out.println("In ClassB Static");
	}
	public ClassB(){
		System.out.println("ClassB()");
	}
}
class ClassC extends ClassB{
	static{
		System.out.println("In ClassC Static");
	}
	public ClassC(){
		System.out.println("ClassC()");
	}
}
class MyClass {
	static ClassA ca = new ClassA();
	ClassC cc = new ClassC();
	static{
		System.out.println("In Static MyClass");
	}
	public MyClass(){
		System.out.println("MyClass()");
	}
}
public class TestMain{
	public static void main(String args[]){
		MyClass mc1 = new MyClass();
		MyClass mc2 = new MyClass();
		System.out.println(mc1.cc == mc2.cc);
		System.out.println(mc1.ca == mc2.ca);
	}
}
	/*
	* In ClassA Static
	* ClassA()
	* In Static MyClass
	* In ClassB Static
	* In ClassC Static
	* ClassB()
	* ClassC()
	* MyClass()
	*
	 * ClassB()
	 * ClassC()
	 * MyClass()
	 *
	 * false
	 * true
	* */
