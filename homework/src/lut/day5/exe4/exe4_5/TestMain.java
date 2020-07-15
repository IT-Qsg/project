package lut.day5.exe4.exe4_5;

public class TestMain{
	public static void main(String args[]){
		Super sup = new Sub();
		sup.m1();
		sup.m2();
		sup.m1();
		Sub sub = (Sub) sup;
		sub.m1();
		sub.m1();
		sub.m2();
	}
}