package lut.day5.exe4.exe4_7;

public class TestMain{
	public static void main(String args[]){
		MyClass mc = new MyClass();
		int value = 5;
		final int fvalue = 10;
		mc.printValue(value); //1
		mc.printValue(fvalue); //2
		mc.changeValue(value); //3
		mc.changeValue(fvalue);//4
	}
}