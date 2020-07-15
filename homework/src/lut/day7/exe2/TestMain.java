package lut.day7.exe2;

class Super{
	public final void m1(){
		System.out.println("m1() in Super");
	}	
	public void m1(int i){
		System.out.println("m1(int) in Super");
	}
}
class Sub extends Super{
	public void m1(int i){
		System.out.println("m1(int) in Sub");
	}
	public void m1(double d){
		System.out.println("m1(double) in Sub");
	}
}
public class TestMain{
	public static void main(String args[]){
		Sub s = new Sub();
		s.m1();
		s.m1(10);
		s.m1(1.5);
	}
}